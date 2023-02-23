# Front-end

<!-- TOC -->

- [Description](#description)
- [How to use](#how-to-use)
  - [Installation](#installation)
  - [Compiles and minifies for production](#compiles-and-minifies-for-production)
  - [Test](#test)
  - [Lints and fixes files](#lints-and-fixes-files)
  - [Compiles and hot-reloads for development](#compiles-and-hot-reloads-for-development)
  - [Preview](#preview)
  - [Customize configuration](#customize-configuration)

<!-- /TOC -->

## Description

This template should help get you started developing with Vue 3 in Vite. [Vuetify](https://vuetifyjs.com) is used as UI Component Framework.

## How to use

The front-end has the following scripts:
Script | Description
------ | -----------
`build` | This script will first run `vue-tsc` to check the TypeScript code for errors but won't emit any compiled code. After that, it will use `vite` to build the project for production. It is described in section [Compiles and minifies for production](#compiles-and-minifies-for-production).
`test` | This script will run the test suite using `jest`. It is described in section [Test](#test).
`lint` | This script will run `eslint` to check the code for errors and fix any that can be automatically corrected. It will also ignore files specified in `.gitignore`. It is described in section [Lints and fixes files](#lints-and-fixes-files).
`dev` | This script will start a development server using `vite`. Is is described in section [Compiles and hot-reloads for development](#compiles-and-hot-reloads-for-development).
`preview` | This script will start a server to preview the production build of the project using `vite`. Is is described in section [Preview](#preview).

### Installation

```sh
# yarn
yarn

# npm
npm install

# pnpm
pnpm install
```
The result must be as follows:
```sh
yarn install v1.22.19
[1/4] Resolving packages...
[2/4] Fetching packages...
[3/4] Linking dependencies...
[4/4] Building fresh packages...
Done in 4.59s.
```
The dependencies are installed in the folder `node_modules`.

### Compiles and minifies for production

```sh
# yarn
yarn build

# npm
npm run build

# pnpm
pnpm build
```
The result must be as follows:
```sh
yarn run v1.22.19
$ vue-tsc --noEmit && vite build
vite v3.2.5 building for production...
✓ 196 modules transformed.
dist/assets/logo.3f834fa8.svg                            0.51 KiB
dist/assets/materialdesignicons-webfont.861aea05.eot     1214.57 KiB
dist/assets/materialdesignicons-webfont.e52d60f6.woff2   376.33 KiB
dist/assets/materialdesignicons-webfont.48d3eec6.woff    548.61 KiB
dist/assets/materialdesignicons-webfont.bd725a7a.ttf     1214.36 KiB
dist/index.html                                          0.41 KiB
dist/assets/Default.de584bbb.js                          12.22 KiB / gzip: 4.44 KiB
dist/assets/VIcon.34fea5a6.js                            9.12 KiB / gzip: 3.43 KiB
dist/assets/Default.2f8c2b45.css                         3.80 KiB / gzip: 1.04 KiB
dist/assets/VIcon.80009757.css                           1.50 KiB / gzip: 0.60 KiB
dist/assets/webfontloader.b777d690.js                    12.42 KiB / gzip: 4.98 KiB
dist/assets/Home.ea3d4649.js                             21.67 KiB / gzip: 7.57 KiB
dist/assets/Home.55d9a549.css                            30.94 KiB / gzip: 4.44 KiB
dist/assets/index.7b3550bf.js                            106.35 KiB / gzip: 41.89 KiB
dist/assets/index.821b1894.css                           533.95 KiB / gzip: 76.03 KiB
Done in 10.22s.
```
The front-end should be available in `dist/`.

### Test

```sh
# yarn
yarn test
```
The result must be as follows:
```sh
yarn run v1.22.19
$ jest
 PASS  src/sum.test.js
  ✓ adds 1 + 2 to equal 3 (2 ms)

Test Suites: 1 passed, 1 total
Tests:       1 passed, 1 total
Snapshots:   0 total
Time:        0.267 s, estimated 1 s
Ran all test suites.
Done in 0.83s.
```

### Lints and fixes files

```sh
# yarn
yarn lint

# npm
npm run lint

# pnpm
pnpm lint
```
The result must be as follows:
```sh
yarn run v1.22.19
$ eslint . --fix --ignore-path .gitignore
Done in 8.09s.
```

### Compiles and hot-reloads for development

```sh
# yarn
yarn dev

# npm
npm run dev

# pnpm
pnpm dev
```
The result must be as follows:
```sh
  VITE v3.2.5  ready in 334 ms

  ➜  Local:   http://localhost:3000/
  ➜  Network: use --host to expose
```
The front-end should be available by accesing to `http://localhost:3000/`.

### Preview
```sh
# yarn
yarn preview
```
The result must be as follows:
```sh
yarn run v1.22.19
$ vite preview
  ➜  Local:   http://localhost:4173/
  ➜  Network: use --host to expose
```
The front-end should be available by accesing to `http://localhost:4173/`.

### Customize configuration

See [Configuration Reference](https://vitejs.dev/config/).