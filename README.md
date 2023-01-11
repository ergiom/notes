# notes
Demo of simple webapp for storing notes

## Rest API
### Notebooks

#### Get All Notebooks

---
##### Request
```
GET /notebooks
```

##### Response
```
HTTP/1.1 200 OK
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 11 Jan 2023 12:33:41 GMT
Keep-Alive: timeout=60
Connection: keep-alive

[{"id":1,"name":"TestNotebook","notes":[]}]
```

#### Save New Notebook

---
##### Request
```
POST /notebooks/new

{
"name": "TestNotebook"
}
```

##### Response

```
HTTP/1.1 200 OK
Content-Length: 0
Date: Wed, 11 Jan 2023 12:35:30 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

#### Get Notebook By Id

---
##### Request
```
GET /notebooks/id
```

##### Response
```
HTTP/1.1 200 OK
Content-Length: 0
Date: Wed, 11 Jan 2023 12:35:30 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{"id":2,"name":"UpdatedNotebook","notes":[{"id":1,"name":"testNote","content":"abc\ndef"}]}
```

#### Delete Notebook

---
##### Request
```
DELETE /notebooks/id
```

##### Response
```
HTTP/1.1 200 OK
Content-Length: 0
Date: Wed, 11 Jan 2023 12:38:39 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

#### Update Notebook

---
##### Request
```
PUT /notebooks/id

{
"name": "UpdatedNotebook"
}
```

##### Response
```
HTTP/1.1 200 OK
Content-Length: 0
Date: Wed, 11 Jan 2023 12:39:54 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

### Notes

#### Get Notes from the Notebook

---
##### Request
```
GET /notebooks/id/notes
```

##### Response
```
HTTP/1.1 200 OK
Content-Length: 0
Date: Wed, 11 Jan 2023 12:39:54 GMT
Keep-Alive: timeout=60
Connection: keep-alive

[{"id":1,"name":"testNote","content":"abc\ndef"}]
```

#### Save Note to the Notebook

---
##### Request
```
POST /notebooks/2/notes

{
"name": "testNote",
"content": "abc\ndef"
}
```

##### Response
```
HTTP/1.1 200 OK
Content-Length: 0
Date: Wed, 11 Jan 2023 12:43:56 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

#### Get Note from the Notebook

---
##### Request
```
GET /notebooks/2/notes/1
```
##### Response
```
HTTP/1.1 200 OK
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 11 Jan 2023 12:46:49 GMT
Keep-Alive: timeout=60
Connection: keep-alive
 
{"id":1,"name":"testNote","content":"abc\ndef"}
```