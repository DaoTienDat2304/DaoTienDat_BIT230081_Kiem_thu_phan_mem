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

- Avg Response Time: 409.46 ms
- Throughput: 10.25 req/s
- Error Rate: 0%

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/1ebe6758-201b-40a4-8b94-8a3f8d8be3fd" />

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/024cf4ef-ac19-4f60-b90e-fbc71f7bb354" />


Nhận xét:

Website hoạt động ổn định với tải nhẹ, không xảy ra lỗi. Thời gian phản hồi ở mức chấp nhận được, request đầu tiên có độ trễ cao do khởi động ban đầu.

### 3.2. Kiểm thử tải nặng (Thread Group 2)

50 users, Ramp-up 30s, Loop 3

Request: Trang chủ (/) và Tìm kiếm (/tim-kiem)

Kết quả:

- Avg Response Time: 49.83 ms
- Throughput: 20.22 req/s
- Error Rate: 0%

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/4ffba9f0-c437-45aa-9f2e-6899706d16da" />

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/33cc92b2-2938-439f-866d-088fdf0f1479" />


Nhận xét:

Khi tăng số người dùng, thời gian phản hồi giảm đáng kể nhờ cơ chế cache và tái sử dụng kết nối. Website xử lý tốt tải cao với nhiều người dùng đồng thời.

### 3.3. Kiểm thử tùy chỉnh (Thread Group 3)

20 users, Ramp-up 20s, chạy 60s

Request: /thoi-su, /the-thao

Kết quả:

- Avg Response Time: 134.47 ms
- Throug4. Kết luận

Website VnExpress.net có hiệu năng tốt, phản hồi nhanh, ổn định và không phát sinh lỗi ở các mức tải khác nhau. Hệ thống có khả năng mở rộng tốt và cơ chế bảo vệ hợp lý khi bị truy cập liên tục.
