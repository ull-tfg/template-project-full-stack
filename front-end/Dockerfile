# Develop stage
FROM node:alpine as develop-stage

ARG GITHUB_TOKEN=${GITHUB_TOKEN}
ENV GITHUB_TOKEN=${GITHUB_TOKEN}

WORKDIR /usr/src/app
COPY package.json ./

RUN echo //npm.pkg.github.com/:_authToken=$GITHUB_TOKEN >> ./.npmrc
RUN yarn install -all
RUN echo > ./.npmrc
COPY . ./

# Build stage
FROM develop-stage as build-stage
RUN yarn build

# Production stage
FROM nginx:alpine as production-stage
COPY --from=build-stage /usr/src/app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]