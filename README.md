# ES_IAP
Projeto Individual da Cadeira de Engenharia de Software 2024/2025

## Development Guides

### Frontend
On ./to-do-list-app run:

```bash
npm install # if it's the first time
npm run dev # to start the development server
```

### Database (before backend!)
On ./ run:

```bash
docker-compose up -d # to start the postgres database
```

#### Accessing the database

```bash
docker exec -it todopostgres psql -U todouser -d todo
```

#### Stopping the database

```bash
docker-compose down -v
```

### Backend
On ./to-do-list run:

```bash
mvn spring-boot:run # to start the backend server
```

#### Documentation
To access the API documentation, go to http://localhost:8080/swagger-ui.html

