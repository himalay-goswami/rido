# Overview
This repository contains a highly scalable and efficient Plagiarism Detector Algorithm designed to handle large datasets with modular services for different functionalities. 
It supports user authentication, language detection, task management, parallel execution for large datasets, and caching for improved performance. The Plagiarism Detector Algorithm is a microservices-based system that detects plagiarized content by breaking large datasets into manageable chunks, 
processing them in parallel, and caching frequently used data to improve performance.

# Features
	•	Role-Based Access Control (RBAC): Ensures secure access to the system based on user roles.
	•	Language Detection: Automatically identifies the language of the text to ensure accurate matching.
	•	Core Matching Algorithm: Compares chunks of text to detect plagiarism with high precision.
	•	Parallel Execution: Efficiently processes large datasets (e.g., texts with more than 10,000 words) using parallel tasks.
	•	Chunk Detection Service: Handles datasets exceeding 100,000 words by breaking them into smaller chunks for processing.
	•	Caching: Uses frequency-based caching to optimize the detection process for common text fragments.

Services

1. User-Service
	•	Purpose: Authenticates users and manages RBAC (Role-Based Access Control).
	•	Features:
	•	User login and JWT-based authentication.
	•	Role-based permissions (e.g., admin, user, reviewer).

2. Language-Service
	•	Purpose: Detects the language of the input text.
	•	Features:
	•	Supports multiple languages.
	•	Integrates with core matcher algorithms to adapt to the language context.

3. Task-Service
	•	Purpose: Hosts the core plagiarism detection algorithm.
	•	Features:
	•	Text comparison using string matching techniques (e.g., cosine similarity, Jaccard index).
	•	Supports multiple text formats and datasets.

4. Job-Service
	•	Purpose: Manages parallel execution for large datasets.
	•	Features:
	•	Breaks input texts into smaller jobs for efficient processing.
	•	Monitors and orchestrates the execution of jobs.

5. Chunk Detection Service
	•	Purpose: Handles datasets with more than 100,000 words by splitting them into smaller, manageable chunks.
	•	Features:
	•	Splits large datasets dynamically.
	•	Ensures efficient chunk processing with minimal overhead.

6. Matcher-Service
	•	Purpose: Caches frequently used text fragments to speed up detection.
	•	Features:
	•	Frequency-based caching to reduce redundant computations.
	•	Optimized for high-throughput scenarios.

Usage
	1.	Authenticate User:
	•	Use the user-service API to log in and obtain a JWT token.
	•	Include the token in the Authorization header for subsequent requests.
	2.	Submit Text for Plagiarism Detection:
	•	Send the text to the task-service or chunk detection service (for large texts).
	•	Optionally use language-service to detect the text’s language before submission.
	3.	Monitor Jobs:
	•	Use the job-service API to track progress for large datasets.
	4.	Caching:
	•	Reuse results for frequent text comparisons with the matcher-service.

 API Endpoints

User-Service
	•	POST /auth/login: Authenticate user and retrieve JWT token.
	•	POST /auth/register: Register a new user.

Language-Service
	•	POST /language/detect: Detect the language of the input text.

Task-Service
	•	POST /task/compare: Submit text for plagiarism detection.

Job-Service
	•	GET /job/status/{jobId}: Check the status of a running job.

Chunk Detection Service
	•	POST /chunk/process: Submit large texts (more than 100,000 words).

Matcher-Service
	•	GET /matcher/cache/{text}: Retrieve cached results for frequent text fragments.

UML Diagram of service representation:
               +-----------------+               +----------------+
              |   User-Service  |<--------------|    Frontend    |
              +-----------------+               +----------------+
                        |
                        v
              +-----------------+
              | Language-Service|
              +-----------------+
                        |
                        v
              +-----------------+
              |   Task-Service  |
              +-----------------+
                        |
         +--------------+--------------+
         |                             |
+------------------+        +------------------+
|   Job-Service    |        | Chunk Detection  |
| (Parallel Tasks) |        |    Service       |
+------------------+        +------------------+
                        |
                        v
              +-----------------+
              | Matcher-Service |
              +-----------------+
