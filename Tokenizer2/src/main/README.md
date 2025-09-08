# Text Similarity Checker (Plagiarism Detector)

## Objective
A Java-based **Text Similarity Checker (Plagiarism Detector)** that compares two documents, computes a similarity score, highlights matches, and exports results.

## Technologies Used
- **Java**
- **Apache Lucene**

## Features
- Compare two documents for textual similarity
- Tokenize and preprocess content (remove stopwords and punctuation)
- Cosine similarity computation
- Highlight matching phrases
- Display similarity percentage
- Export results as PDF or text

## File Structure

```
Tokenizer2/
└── src/
    └── main/
        ├── java/
        │   ├── [Your Java source files]
        │   └── ...
        ├── resources/
        │   ├── stopwords.txt
        │   └── ...
        └── README.md
```

- `java/`: Contains Java source code, including tokenization, similarity computation, and result export logic.
- `resources/`: Contains support files such as stopwords lists.
- `README.md`: This file.

## How It Works

1. **Read Input Files**  
   Accepts two document files, reads and loads content.

2. **Tokenization & Preprocessing**  
   Tokenizes content, removes stopwords and punctuation using Lucene.

3. **Cosine Similarity Calculation**  
   Converts documents to vectors and computes cosine similarity.

4. **Highlight Matching Phrases**  
   Identifies and highlights similar/matching phrases.

5. **Display Similarity Percentage**  
   Shows similarity score as a percentage.

6. **Export Results**  
   Exports analysis as PDF or text.

## Getting Started

### Prerequisites
- Java 8+
- Apache Lucene

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Deb2003-21/ELEVATE-LABS.git
   ```

2. Navigate to the project directory:
   ```bash
   cd ELEVATE-LABS/Tokenizer2/src/main
   ```

3. Add Apache Lucene to your project dependencies.

### Usage

Run the main class and provide two document file paths as input. The tool processes files, computes similarity, highlights matches, and offers export options.

## Example Output

```
Document 1: fileA.txt
Document 2: fileB.txt

Similarity: 82%
Matching phrases:
- "machine learning techniques"
- "text analysis with Lucene"
...
Results exported as: result.pdf
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

MIT License

---

**Author:** [Deb2003-21](https://github.com/Deb2003-21)