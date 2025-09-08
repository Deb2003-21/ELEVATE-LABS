<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File Similarity Checker</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            max-width: 1000px;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            backdrop-filter: blur(10px);
        }

        .header {
            background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
            color: white;
            text-align: center;
            padding: 30px;
        }

        .header h1 {
            font-size: 2.5em;
            font-weight: 300;
            margin-bottom: 10px;
        }

        .header p {
            opacity: 0.9;
            font-size: 1.1em;
        }

        .form-section {
            padding: 40px;
        }

        .form-group {
            margin-bottom: 25px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #333;
            font-size: 1.1em;
        }

        .file-input-wrapper {
            position: relative;
            display: inline-block;
            width: 100%;
        }

        .file-input {
            position: absolute;
            opacity: 0;
            width: 100%;
            height: 100%;
            cursor: pointer;
        }

        .file-input-display {
            display: flex;
            align-items: center;
            padding: 15px 20px;
            border: 2px dashed #ddd;
            border-radius: 10px;
            background: #f8f9fa;
            transition: all 0.3s ease;
            cursor: pointer;
        }

        .file-input-display:hover {
            border-color: #4facfe;
            background: #f0f8ff;
        }

        .file-icon {
            width: 24px;
            height: 24px;
            margin-right: 15px;
            opacity: 0.6;
        }

        .file-text {
            color: #666;
            font-size: 1em;
        }

        .submit-btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            padding: 15px 40px;
            border-radius: 50px;
            font-size: 1.2em;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.3);
            width: 100%;
            margin-top: 20px;
        }

        .submit-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 15px 30px rgba(102, 126, 234, 0.4);
        }

        .results-section {
            background: #f8f9fa;
            padding: 30px 40px;
            border-top: 1px solid #eee;
        }

        .similarity-score {
            text-align: center;
            margin-bottom: 30px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .score-circle {
            display: inline-block;
            width: 150px;
            height: 150px;
            border-radius: 50%;
            background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 15px;
            box-shadow: 0 10px 30px rgba(79, 172, 254, 0.3);
        }

        .score-text {
            color: white;
            font-size: 2.2em;
            font-weight: bold;
            text-align: center;
        }

        .score-label {
            font-size: 1.2em;
            color: #333;
            font-weight: 600;
        }

        .common-words-section {
            margin-top: 30px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .section-title {
            font-size: 1.5em;
            color: #333;
            margin-bottom: 20px;
            text-align: center;
            font-weight: 600;
        }

        .words-container {
            display: flex;
            justify-content: center;
            width: 100%;
            max-width: 800px;
        }

        .file-words {
            background: white;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            text-align: center;
            margin: 0 auto;
        }

        .file-title {
            font-size: 1.4em;
            color: #667eea;
            margin-bottom: 20px;
            font-weight: 600;
            text-align: center;
        }

        .word-list {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            justify-content: center;
        }

        .word-tag {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 1em;
            font-weight: 500;
        }

        .no-results {
            text-align: center;
            color: #666;
            font-style: italic;
            padding: 40px;
        }

        .pdf-export-section {
            margin-top: 30px;
            text-align: center;
            padding-top: 20px;
            border-top: 1px solid #eee;
        }

        .download-btn {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
            border: none;
            padding: 12px 30px;
            border-radius: 25px;
            font-size: 1.1em;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 5px 15px rgba(40, 167, 69, 0.3);
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            gap: 8px;
        }

        .download-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(40, 167, 69, 0.4);
            text-decoration: none;
            color: white;
        }

        .download-btn:disabled {
            background: #6c757d;
            cursor: not-allowed;
            transform: none;
            box-shadow: none;
        }

        .loading-spinner {
            width: 20px;
            height: 20px;
            border: 2px solid #ffffff;
            border-top: 2px solid transparent;
            border-radius: 50%;
            animation: spin 1s linear infinite;
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }

        .pdf-status {
            margin-top: 15px;
            font-size: 0.9em;
            color: #666;
        }

        @media (max-width: 768px) {
            .container {
                margin: 10px;
                border-radius: 15px;
                max-width: 95%;
            }
            
            .header h1 {
                font-size: 2em;
            }
            
            .form-section {
                padding: 30px 20px;
            }
            
            .words-container {
                max-width: 100%;
            }
            
            .file-words {
                max-width: 100%;
                padding: 25px 15px;
            }
            
            .score-circle {
                width: 120px;
                height: 120px;
            }
            
            .score-text {
                font-size: 1.8em;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>File Similarity Checker</h1>
            <p>Upload two files to analyze their content similarity and common words</p>
        </div>
        
        <div class="form-section">
            <form action="Token" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="file1">Select First File:</label>
                    <div class="file-input-wrapper">
                        <input type="file" name="file1" id="file1" class="file-input" accept=".txt,.doc,.docx,.pdf">
                        <div class="file-input-display">
                            <svg class="file-icon" viewBox="0 0 24 24" fill="none" stroke="currentColor">
                                <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                                <polyline points="14,2 14,8 20,8"></polyline>
                            </svg>
                            <span class="file-text">Click to browse or drag file here</span>
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="file2">Select Second File:</label>
                    <div class="file-input-wrapper">
                        <input type="file" name="file2" id="file2" class="file-input" accept=".txt,.doc,.docx,.pdf">
                        <div class="file-input-display">
                            <svg class="file-icon" viewBox="0 0 24 24" fill="none" stroke="currentColor">
                                <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                                <polyline points="14,2 14,8 20,8"></polyline>
                            </svg>
                            <span class="file-text">Click to browse or drag file here</span>
                        </div>
                    </div>
                </div>
                
                <button type="submit" class="submit-btn">Check Similarity</button>
            </form>
        </div>

        <% if (request.getAttribute("similarity") != null) { %>
        <div class="results-section">
            <div class="similarity-score">
                <div class="score-circle">
                    <span id="similarityData" class="score-text"><%= request.getAttribute("similarity") %>%</span>
                </div>
                <div class="score-label">Similarity Score</div>
            </div>
            
            <div class="common-words-section">
                <h3 class="section-title">Most Common Words</h3>
                
                <% if (request.getAttribute("common1") != null ) { %>
                <div class="words-container">
                    <div class="file-words">
                        <div class="file-title">Top Words</div>
                        <div id="commonWordsData" class="word-list">
                            <% 
                            java.util.List<String> file1Words = (java.util.List<String>) request.getAttribute("common1");
                            if (file1Words != null && !file1Words.isEmpty()) {
                                for (String word : file1Words) { 
                            %>
                                <span class="word-tag"><%= word %></span>
                            <% 
                                }
                            } else {
                            %>
                                <span class="no-results">No common words found</span>
                            <% } %>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>

            <!-- PDF Export Section -->
            <div class="pdf-export-section">
                <button id="downloadBtn" class="download-btn" onclick="generateAndDownloadPDF()">
                    <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                        <path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"></path>
                        <polyline points="7,10 12,15 17,10"></polyline>
                        <line x1="12" y1="15" x2="12" y2="3"></line>
                    </svg>
                    Download PDF Report
                </button>
                <div id="pdfStatus" class="pdf-status"></div>
            </div>
        </div>
        <% } %>
    </div>

    <script>
        // File input enhancement
        document.addEventListener('DOMContentLoaded', function() {
            const fileInputs = document.querySelectorAll('.file-input');
            
            fileInputs.forEach(input => {
                const display = input.nextElementSibling;
                const textSpan = display.querySelector('.file-text');
                
                input.addEventListener('change', function() {
                    if (this.files && this.files[0]) {
                        textSpan.textContent = this.files[0].name;
                        display.style.borderColor = '#4facfe';
                        display.style.background = '#f0f8ff';
                    } else {
                        textSpan.textContent = 'Click to browse or drag file here';
                        display.style.borderColor = '#ddd';
                        display.style.background = '#f8f9fa';
                    }
                });
            });
        });

        // PDF Generation and Download Function
        function generateAndDownloadPDF() {
            const downloadBtn = document.getElementById('downloadBtn');
            const pdfStatus = document.getElementById('pdfStatus');
            
            // Disable button and show loading state
            downloadBtn.disabled = true;
            downloadBtn.innerHTML = `
                <div class="loading-spinner"></div>
                Generating PDF...
            `;
            pdfStatus.textContent = 'Preparing PDF report...';
            
            // Prepare the result data
            const similarity = document.getElementById("similarityData").textContent ;
    		const wordTags = document.querySelectorAll("#commonWordsData .word-tag");
    		const commonWords = Array.from(wordTags).map(tag => tag.textContent);
    		
    		console.log(commonWords)
            
            // Create result string with similarity and matches

             const formData = new FormData();
             formData.append("similarity", similarity);
             formData.append("commonWords", JSON.stringify(commonWords)); // Send as JSON string


fetch("http://localhost:8080/Tokenizer2/show_pdf", {
    method: "POST",
    body: formData
})
.then(res => {
    if(!res.ok) throw new Error("Network error");
    return res.blob();
})
            .then(blob => {
                // Create download link
                const url = window.URL.createObjectURL(blob);
                const a = document.createElement('a');
                a.style.display = 'none';
                a.href = url;
                a.download = 'similarity_report.pdf';
                document.body.appendChild(a);
                a.click();
                
                // Clean up
                window.URL.revokeObjectURL(url);
                document.body.removeChild(a);
                
                // Update UI
                pdfStatus.textContent = 'PDF downloaded successfully!';
                pdfStatus.style.color = '#28a745';
                
                // Reset button after delay
                setTimeout(() => {
                    downloadBtn.disabled = false;
                    downloadBtn.innerHTML = `
                        <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                            <path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"></path>
                            <polyline points="7,10 12,15 17,10"></polyline>
                            <line x1="12" y1="15" x2="12" y2="3"></line>
                        </svg>
                        Download PDF Report
                    `;
                    pdfStatus.textContent = '';
                    pdfStatus.style.color = '#666';
                }, 2000);
            })
            .catch(error => {
                console.error('Error generating PDF:', error);
                pdfStatus.textContent = 'Error generating PDF. Please try again.';
                pdfStatus.style.color = '#dc3545';
                
                // Reset button
                downloadBtn.disabled = false;
                downloadBtn.innerHTML = `
                    <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                        <path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"></path>
                        <polyline points="7,10 12,15 17,10"></polyline>
                        <line x1="12" y1="15" x2="12" y2="3"></line>
                    </svg>
                    Download PDF Report
                `;
                
                // Clear error message after delay
                setTimeout(() => {
                    pdfStatus.textContent = '';
                    pdfStatus.style.color = '#666';
                }, 3000);
            });
        }
    </script>
</body>
</html>