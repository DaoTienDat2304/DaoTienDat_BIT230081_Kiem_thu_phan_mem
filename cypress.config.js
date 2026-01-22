const { defineConfig } = require('cypress')

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
    baseUrl: 'https://www.saucedemo.com',
    viewportWidth: 1280,
    viewportHeight: 720,
    pageLoadTimeout: 120000,
    defaultCommandTimeout: 10000,
    chromeWebSecurity: false, // Tắt bảo mật để tránh lỗi CORS và requests bị chặn
    videoCompression: false,
    video: false,
  },
})


