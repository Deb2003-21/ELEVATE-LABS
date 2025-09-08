# Text Similarity Checker (Plagiarism Detector)

## Objective
A Java-based **Text Similarity Checker (Plagiarism Detector)** that compares two documents, computes a similarity score, highlights matches, and exports results
in pdf.

## Technologies Used
- **Java J2EE**
- **Apache Lucene**
- **iText 7**

## Features
- Compare two documents for textual similarity
- Tokenize and preprocess content (remove stopwords and punctuation using lucene tokenizer)
- Cosine similarity computation
- Highlight matching words
- Display similarity percentage
- Export results as PDF or text

## File Structure

```
Tokenizer2/
└── src/
    └── main/
        ├── java/
        │   ├── org/
        │      └── tokenizer2/
        │             └── Controller/
        |               └── Token.java
        |               └── pdf_creator.java    
        ├── webapp/
        |       └──  index.jsp  
        └── README.md
```

- `java/`: Contains Java source code, including tokenization, similarity computation, and result export logic.
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
- Apache Lucene (library)
- iText 7 (library)

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

## Example Output

<img width="1257" height="702" alt="image" src="https://github.com/user-attachments/assets/63dcb373-cf42-4c5c-b306-4152e55f95ea" />


Plagiarism Detection Report
------------------------------
similarity:
70% , 
common words:
["machin","learn","artifici","intellig","train","model"]


## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

MIT License

---

**Author:** [Deb2003-21](https://github.com/Deb2003-21)
