# Blogs
https://roadmap.sh/projects/blogging-platform-api

Personal Blogging Platform – RESTful API
📌 Project Overview

This project is a RESTful API for a personal blogging platform that allows users to perform basic CRUD operations (Create, Read, Update, Delete) on blog posts. The goal of this project is to learn and apply REST API best practices, proper use of HTTP methods, error handling, and database integration.

🎯 Features

Create Blog Post – Add a new blog post with title, content, category, and tags

Read Blog Posts – Retrieve all posts or a single post by ID

Update Blog Post – Modify an existing blog post by ID

Delete Blog Post – Remove a blog post by ID

Search Blog Posts – Filter posts by a search term (title, content, or category)

🔑 API Endpoints
➕ Create a Blog Post

POST /posts
Request Body:

{
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}


Response: 201 Created

{
  "id": 1,
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2021-09-01T12:00:00Z",
  "updatedAt": "2021-09-01T12:00:00Z"
}

✏ Update a Blog Post

PUT /posts/{id}

❌ Delete a Blog Post

DELETE /posts/{id}

📖 Get a Single Blog Post

GET /posts/{id}

📚 Get All Blog Posts

GET /posts

🔍 Search Blog Posts

GET /posts?term=tech

⚙️ Tech Stack

Language/Framework: Java + Spring Boot

Database: MySQL

Tools: Maven, Postman (for testing)

🚀 Learning Outcomes

Gained hands-on experience with RESTful API design

Implemented CRUD operations using Spring Boot & MySQL

Practiced HTTP methods (GET, POST, PUT, DELETE) with correct status codes

Improved skills in error handling and validation

Learned to implement search/filtering functionality
