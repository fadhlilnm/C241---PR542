FROM node:20
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
ENV MODEL_URL=""
ENV PORT=5000
EXPOSE 5000
CMD [ "npm", "start" ]