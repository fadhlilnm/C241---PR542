FROM node:20
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
ENV PATH_TO_CSV_FILES="/usr/src/app/data_csv"
ENV PORT=5000
EXPOSE 5000
CMD [ "npm", "run", "start" ]
