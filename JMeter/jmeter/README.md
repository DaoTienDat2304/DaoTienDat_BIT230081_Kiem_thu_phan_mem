# BÁO CÁO KIỂM THỬ HIỆU NĂNG WEBSITE BẰNG JMETER

## 1. Thông tin chung

Họ và tên: Đào Tiến Đạt

MSSV: BIT230081

Lớp: SOFT2

Website kiểm thử: https://vnexpress.net

Công cụ: Apache JMeter 5.6.3

## 2. Mục tiêu

Đánh giá hiệu năng website VnExpress.net thông qua các chỉ số Response Time, Throughput và Error Rate ở nhiều mức tải khác nhau.

## 3. Kết quả kiểm thử

### 3.1. Kiểm thử tải nhẹ (Thread Group 1)

10 users, Ramp-up 10s, Loop 5

Request: Trang chủ (/)

Kết quả:

- Avg Response Time: 409 ms
- Throughput: 5.1 req/s
- Error Rate: 0%

Nhận xét:

Website hoạt động ổn định với tải nhẹ, không xảy ra lỗi. Thời gian phản hồi ở mức chấp nhận được, request đầu tiên có độ trễ cao do khởi động ban đầu.

### 3.2. Kiểm thử tải nặng (Thread Group 2)

50 users, Ramp-up 30s, Loop 3

Request: Trang chủ (/) và Tìm kiếm (/tim-kiem)

Kết quả:

- Avg Response Time: 67 ms
- Throughput: 10.1 req/s
- Error Rate: 0%

Nhận xét:

Khi tăng số người dùng, thời gian phản hồi giảm đáng kể nhờ cơ chế cache và tái sử dụng kết nối. Website xử lý tốt tải cao với nhiều người dùng đồng thời.

### 3.3. Kiểm thử tùy chỉnh (Thread Group 3)

20 users, Ramp-up 20s, chạy 60s

Request: /thoi-su, /the-thao

Kết quả:

- Avg Response Time: 50 ms
- Throughput: 19.5 req/s
- Error Rate: 0%

Nhận xét:

Website đạt hiệu năng tốt nhất trong kịch bản này với thông lượng cao và thời gian phản hồi thấp. Sau thời gian chạy dài, hệ thống kích hoạt giới hạn truy cập để bảo vệ server.

## 4. So sánh tổng hợp

| Group | Users | Avg Response (ms) | Throughput (req/s) | Error |
|-------|-------|-------------------|--------------------| ------|
| 1     | 10    | 409               | 5.1                | 0%    |
| 2     | 50    | 67                | 10.1               | 0%    |
| 3     | 20    | 50                | 19.5               | 0%    |

## 5. Kết luận

Website VnExpress.net có hiệu năng tốt, phản hồi nhanh, ổn định và không phát sinh lỗi ở các mức tải khác nhau. Hệ thống có khả năng mở rộng tốt và cơ chế bảo vệ hợp lý khi bị truy cập liên tục.
