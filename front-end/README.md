# Front-end

<!-- TOC -->

- [Project Setup](#project-setup)
  - [Compile and Hot-Reload for Development](#compile-and-hot-reload-for-development)
  - [Type-Check, Compile and Minify for Production](#type-check-compile-and-minify-for-production)
  - [Run Unit Tests with Vitest](#run-unit-tests-with-vitest)
  - [Run End-to-End Tests with Cypress](#run-end-to-end-tests-with-cypress)
  - [Lint with ESLint](#lint-with-eslint)

<!-- /TOC -->

# Description

This template should help get you started developing with Vue 3 in Vite. It has been created by following the guidelines provided [here](https://vuejs.org/guide/quick-start.html#creating-a-vue-application):
```sh
npm init vue@latest
Need to install the following packages:
  create-vue@3.4.0
Ok to proceed? (y) 

Vue.js - The Progressive JavaScript Framework

✔ Project name: … front-end
✔ Add TypeScript? … No / Yes
✔ Add JSX Support? … No / Yes
✔ Add Vue Router for Single Page Application development? … No / Yes
✔ Add Pinia for state management? … No / Yes
✔ Add Vitest for Unit Testing? … No / Yes
✔ Add an End-to-End Testing Solution? › Cypress
✔ Add ESLint for code quality? … No / Yes
✔ Add Prettier for code formatting? … No / Yes

Scaffolding project in /ull-tfg/template-project-full-stack/front-end...

Done. Now run:

  cd front-end
  npm install
  npm run lint
  npm run dev
```

# How to use

## Project Setup

```sh
npm install
```
The results must be similar to this:
```sh
added 571 packages, and audited 572 packages in 49s

115 packages are looking for funding
  run `npm fund` for details

found 0 vulnerabilities
```

### Compile and Hot-Reload for Development

The Vite development server can be started by running the following commands:
```sh
npm run dev
```
The result must be similar to this:
```sh
  VITE v3.2.3  ready in 506 ms

  ➜  Local:   http://localhost:5173/
  ➜  Network: use --host to expose
```
The front-end should be available by accesing to `http://localhost:5173/`.

### Type-Check, Compile and Minify for Production

```sh
npm run build
```

### Run Unit Tests with [Vitest](https://vitest.dev/)

```sh
npm run test:unit
```

### Run End-to-End Tests with [Cypress](https://www.cypress.io/)

```sh
npm run test:e2e:dev
```

This runs the end-to-end tests against the Vite development server.
It is much faster than the production build.

But it's still recommended to test the production build with `test:e2e` before deploying (e.g. in CI environments):

```sh
npm run build
npm run test:e2e
```

### Lint with [ESLint](https://eslint.org/)

```sh
npm run lint
```