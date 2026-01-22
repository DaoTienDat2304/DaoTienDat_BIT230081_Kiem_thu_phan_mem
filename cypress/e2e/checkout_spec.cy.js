describe('Checkout Test', () => {
  beforeEach(() => {
    cy.visit('https://www.saucedemo.com');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
  });

  it('Should complete checkout process and reach confirmation page', () => {
    // Thêm sản phẩm vào giỏ hàng
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
    
    // Đi đến trang giỏ hàng
    cy.get('.shopping_cart_link').click();
    cy.url().should('include', '/cart.html');
    
    // Nhấn nút Checkout
    cy.get('#checkout').click();
    cy.url().should('include', '/checkout-step-one.html');
    
    // Điền thông tin thanh toán (First Name: John, Last Name: Doe, Zip Code: 12345)
    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');
    
    // Nhấn nút Continue
    cy.get('#continue').click();
    
    // Xác minh rằng người dùng được chuyển đến trang xác nhận thanh toán (/checkout-step-two.html)
    cy.url().should('include', '/checkout-step-two.html');
  });
});


