# Programming Languages API
API developed as a study project during the workshop "Imersão Java" from Alura. The main functionality is to retrieve different programming languages from the database, allowing the client to use the information for multiple purposes.

## Endpoints
### Methods: GET and POST
`https://program-languages-api.herokuapp.com/languages`

To create a new language, the requisition body have to be in JSON, according to the following example:
```
{
    "name": "example",
    "logo": "logo-url-example",
    "ranking" 99
} 
```

### Methods: PATCH and DELETE
`https://program-languages-api.herokuapp.com/languages/{id}`

## Stacks
- Java 17;
- Spring Boot;
- Mongo DB Atlas;