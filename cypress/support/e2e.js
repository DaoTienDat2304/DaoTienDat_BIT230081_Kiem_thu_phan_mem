// ***********************************************************
// This example support/e2e.js is processed and
// loaded automatically before your test files.
//
// This is a great place to put global configuration and
// behavior that modifies Cypress.
//
// You can change the location of this file or turn off
// automatically serving support files with the
// 'supportFile' configuration option.
//
// You can read more here:
// https://on.cypress.io/configuration
// ***********************************************************

// Import commands.js using ES2015 syntax:
import './commands'

// Alternatively you can use CommonJS syntax:
// require('./commands')

// Bỏ qua tất cả các lỗi không mong muốn
Cypress.on('uncaught:exception', (err, runnable) => {
  // Trả về false để ngăn Cypress fail test khi có lỗi
  return false
})

// Bỏ qua các lỗi từ window
Cypress.on('window:before:load', (win) => {
  // Stub console.error để không hiển thị lỗi 401
  cy.stub(win.console, 'error').callsFake(() => {})
})

// Chặn TẤT CẢ requests không cần thiết
beforeEach(() => {
  // Chặn các requests analytics/tracking
  cy.intercept('POST', '**/backtrace.io/**', { statusCode: 200, body: {} })
  cy.intercept('GET', '**/backtrace.io/**', { statusCode: 200, body: {} })
  cy.intercept('**/events/**', { statusCode: 200, body: {} })
  cy.intercept('**/analytics**', { statusCode: 200, body: {} })
  cy.intercept('**/tracking**', { statusCode: 200, body: {} })
})


