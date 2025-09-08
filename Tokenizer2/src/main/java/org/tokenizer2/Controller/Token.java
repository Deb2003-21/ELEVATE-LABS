package org.tokenizer2.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * Servlet implementation class Token
 */
@WebServlet("/Token")
@MultipartConfig  // Allows file uploads in this servlet
public class Token extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET requests (not used much here)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * Handles POST requests (main logic here)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get uploaded files from HTML form
        Part file1 = request.getPart("file1");
        Part file2 = request.getPart("file2");

        // Read the contents of the files into strings
        String text1 = new String(file1.getInputStream().readAllBytes());
        String text2 = new String(file2.getInputStream().readAllBytes());

        // 2. Tokenize using Lucene (convert text to processed words)
        List<String> tokens1 = tokenize(text1);
        List<String> tokens2 = tokenize(text2);

        // 3. Compute Cosine Similarity between the two token lists
        int similarity = cosineSimilarity(tokens1, tokens2);

        // Find common tokens in both files
        List<String> common_file1 = intersect(tokens1, tokens2);

        // 4. Send results to JSP page
        request.setAttribute("similarity", similarity);
        request.setAttribute("common1", common_file1);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    /**
     * Tokenizes text using Lucene EnglishAnalyzer
     */
    private List<String> tokenize(String text) throws IOException {
        List<String> tokens = new ArrayList<>();

        // Analyzer applies stopword removal, lowercasing, and stemming
        EnglishAnalyzer analyzer = new EnglishAnalyzer();

        // TokenStream processes text and breaks it into tokens
        TokenStream tokenStream = analyzer.tokenStream(null, new StringReader(text));

        // CharTermAttribute gives access to the token text
        CharTermAttribute attr = tokenStream.addAttribute(CharTermAttribute.class);

        // Reset the stream before reading
        tokenStream.reset();

        // Iterate over tokens and store them in the list
        while (tokenStream.incrementToken()) {
            tokens.add(attr.toString());
        }

        // Finalize and close streams
        tokenStream.end();
        tokenStream.close();
        analyzer.close();

        return tokens;
    }

    /**
     * Creates a frequency map of tokens
     */
    private Map<String, Integer> getFrequency(List<String> tokens) {
        Map<String, Integer> freq = new HashMap<>();
        for (String token : tokens)
            freq.put(token, freq.getOrDefault(token, 0) + 1);
        return freq;
    }

    /**
     * Finds intersection (common tokens) between two token lists
     */
    private List<String> intersect(List<String> tokens1, List<String> tokens2) {
        List<String> s = new ArrayList<>(tokens1);
        s.retainAll(tokens2); // keeps only elements present in both lists
        return s;
    }

    /**
     * Calculates cosine similarity between two token lists
     */
    private int cosineSimilarity(List<String> tokens1, List<String> tokens2) {
        Map<String, Integer> freq1 = getFrequency(tokens1);
        Map<String, Integer> freq2 = getFrequency(tokens2);

        // Combine all unique tokens from both texts
        Set<String> allTokens = new HashSet<>(freq1.keySet());
        allTokens.addAll(freq2.keySet());

        double dotProduct = 0.0, mag1 = 0.0, mag2 = 0.0;

        // Calculate dot product and magnitudes
        for (String token : allTokens) {
            int f1 = freq1.getOrDefault(token, 0);
            int f2 = freq2.getOrDefault(token, 0);
            dotProduct += f1 * f2;
            mag1 += f1 * f1;
            mag2 += f2 * f2;
        }

        // Cosine similarity formula: dotProduct / (|A|*|B|)
        double res = (dotProduct / (Math.sqrt(mag1) * Math.sqrt(mag2)));

        // Convert to percentage
        return (int) (res * 100);
    }
}
