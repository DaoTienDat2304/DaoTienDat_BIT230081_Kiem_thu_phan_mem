# Bài tập Kiểm thử Tự động End-to-End với Cypress

## 📋 Mô tả

Dự án kiểm thử tự động cho website **SauceDemo** (https://www.saucedemo.com) sử dụng Cypress.

## 🚀 Yêu cầu hệ thống

- Node.js (phiên bản 14 trở lên)
- npm
- Visual Studio Code (khuyến nghị)

## 📦 Cài đặt

### 1. Cài đặt Node.js
Tải và cài đặt từ: https://nodejs.org/ (chọn phiên bản LTS)

### 2. Cài đặt dependencies
```bash
npm install
```

## 🏃 Chạy kiểm thử

### Mở giao diện Cypress:
```bash
npx cypress open
```

### Chạy tất cả tests trong terminal:
```bash
npx cypress run
```

### Chạy một file cụ thể:
```bash
npx cypress run --spec "cypress/e2e/login_spec.cy.js"
npx cypress run --spec "cypress/e2e/cart_spec.cy.js"
npx cypress run --spec "cypress/e2e/checkout_spec.cy.js"
```

## 📝 Các kịch bản kiểm thử

### 1. Login Test (login_spec.cy.js)

**Test 1: Đăng nhập thành công**
- Truy cập trang https://www.saucedemo.com
- Nhập username: `standard_user`
- Nhập password: `secret_sauce`
- Click nút "Login"
- Xác minh URL chứa `/inventory.html`

**Test 2: Đăng nhập thất bại**
- Truy cập trang https://www.saucedemo.com
- Nhập username không hợp lệ: `invalid_user`
- Nhập password không hợp lệ: `wrong_password`
- Click nút "Login"
- Xác minh hiển thị thông báo lỗi

### 2. Cart Test (cart_spec.cy.js)

**Test 1: Thêm sản phẩm vào giỏ hàng**
- Đăng nhập với thông tin hợp lệ
- Click nút "Add to cart" của sản phẩm đầu tiên
- Xác minh badge giỏ hàng hiển thị số "1"

**Test 2: Sắp xếp sản phẩm theo giá**
- Đăng nhập với thông tin hợp lệ
- Chọn bộ lọc "Price (low to high)"
- Xác minh sản phẩm đầu tiên có giá $7.99

**Test 3: Xóa sản phẩm khỏi giỏ hàng**
- Đăng nhập và thêm sản phẩm vào giỏ hàng
- Click nút "Remove"
- Xác minh badge giỏ hàng không còn hiển thị

### 3. Checkout Test (checkout_spec.cy.js)

**Test: Quy trình thanh toán**
- Đăng nhập với thông tin hợp lệ
- Thêm sản phẩm vào giỏ hàng
- Đi đến trang giỏ hàng
- Click nút "Checkout"
- Điền thông tin:
  - First Name: John
  - Last Name: Doe
  - Zip Code: 12345
- Click nút "Continue"
- Xác minh URL chứa `/checkout-step-two.html`

## 📊 Cấu trúc dự án

```
cypress/
├── e2e/
│   ├── login_spec.cy.js      # 2 tests: đăng nhập
│   ├── cart_spec.cy.js        # 3 tests: giỏ hàng
│   └── checkout_spec.cy.js    # 1 test: thanh toán
├── support/
│   ├── commands.js            # Custom commands
│   └── e2e.js                # Setup file
cypress.config.js              # Cấu hình Cypress
package.json                   # Dependencies
```

## ✅ Kết quả kiểm thử

Tất cả 6 test cases đã được triển khai:
- ✅ Đăng nhập thành công
- ✅ Đăng nhập thất bại
- ✅ Thêm sản phẩm vào giỏ hàng
- ✅ Sắp xếp sản phẩm theo giá
- ✅ Xóa sản phẩm khỏi giỏ hàng
- ✅ Quy trình thanh toán

## 🎓 Tài liệu tham khảo

- [Cypress Documentation](https://docs.cypress.io)
- [SauceDemo Website](https://www.saucedemo.com)
