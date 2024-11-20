FROM node:18

WORKDIR /to-do-list-app

COPY package*.json ./
COPY . .

RUN npm install
RUN npm run build

EXPOSE 3000

CMD ["npm", "start"]