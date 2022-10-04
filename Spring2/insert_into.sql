insert into `category` values
(1, 'Văn Học Việt Nam'),
(2, 'Văn Học Nước Ngoài'),
(3, 'Thiếu Nhi'),
(4, 'Thời Sự - Chính Trị');


INSERT INTO `book`  VALUES 
(1, 'Nguyễn Văn Nghĩa', 'MS001', 'Sẽ có người không khỏi băn khoăn khi cầm cuốn sách khổ lớn ...,', '10', 10.1, 'https://i.pinimg.com/564x/4b/23/a8/4b23a8b278a13ffda37850d9e4d6f0dc.jpg', 'Hẹn nhau bên gốc đa...', 2000, 'NXB Kim Đồng', 100, '2020-09-01', 0, 20, 'Lưu Hòa', 3),
(2, 'Lương Bích Hữu', 'MS002', 'Tôi không thích ồn ào là một cuốn sách đem lại cho chúng ta cảm giác thoải mái và có tĩnh...', '10', 11.1, 'https://sach86.com/wp-content/uploads/2019/12/toi-khong-thich-on-ao.jpg', 'Tôi không thích ồn ào.', 2000, 'NXB Kim Đồng', 100, '2020-09-01', 0, 20, 'Nguyễn Thành Long', 1),
(3, 'Nguyễn Văn Minh', 'MS003', 'Sẽ có người không khỏi băn khoăn khi cầm cuốn sách khổ lớn ...', '10', 11.1, 'https://www.dtv-ebook.com/images/files_2/2019/dung-goi-anh-la-nguoi-yeu-cu-du-phong.jpg', 'Đừng gọi anh là người...', 1000, 'NXB Kim Đồng', 100, '2019-09-01', 0, 20, 'Nguyễn Thành Nhân', 3),
(4, 'Diệp lạc vô tâm', 'MS004', 'Bản thảo Yêu là thế tác giả đã ấp ủ, thai nghén 10 năm,...', '10', 11.1, 'https://downloadsach.com/wp-content/uploads/2018/01/sach-yeu-la-the.jpg', 'Yêu là thế', 2000, 'NXB Văn Học', 100, '2018-09-01', 0, 20, 'Diệp lạc vô tâm', 2),
(5, 'Antoine de Saint-Exupéry', 'MS005', 'Là một truyện ngắn của viên phi công có biệt danh...', '10', 11.1, 'https://product.hstatic.net/200000343865/product/hoang-tu-be---tb-2022_f0f2f9b813c246c4878e7e685f683d50_master.jpg', 'Hoàng tử bé', 2000, 'NXB Kim Đồng', 100, '2020-09-01', 0, 20, 'Nguyễn Văn Trung', 4),
(6, 'Hoàng Anh Tuấn', 'MS006', 'bộ truyện thuần Việt này trở thành “người bạn” đồng hành cùng...', '10', 11.9, 'https://salt.tikicdn.com/cache/w1200/ts/product/c2/22/a7/c11e314e0900d12eda3c5b2b60e9bdee.jpg', 'Lớp học mật ngữ', 2000, 'NXB Kim Đồng', 100, '2022-09-01', 0, 20, 'Hoàng Anh Tuấn', 2),
(7, 'Nguyễn Văn Nghĩa', 'MS007', 'Sẽ có người không khỏi băn khoăn khi cầm cuốn sách khổ lớn ...', '10', 11.1, 'https://diendanlequydon.com/downloads/image_prv/102/101929.jpg', 'Bệnh không thể yêu', 2000, 'NXB Kim Đồng', 100, '2020-09-01', 0, 20, 'Nguyễn Văn Nghĩa', 4),
(8, 'C Wright Mills', 'MS008', 'Giới tinh hoa quyền lực (tên tiếng anh: The Power Elite) xuất bản lần đầu vào năm 1956, thời điểm mà như Mills gọi, khi người Mỹ sống trong “một sự bùng nổ vật chất, một sự ca tụng chủ nghĩa dân tộc, một khoảng trống chính trị”. Dễ hiểu vì sao người Mỹ lại luôn tự mãn như Mills cáo buộc. Đây là cuốn sách quan trọng nhất trong ba cuốn Mills viết về xã hội Mỹ, cùng với The New Men of Power (Con người Quyền lực Mới, 1948) và White Collar (Giới Cổ cồn, 1951).', '10', 11.1, 'https://bizweb.dktcdn.net/100/180/408/products/gioi-tinh-hoa-quyen-luc-2.jpg?v=1606573615897', 'Tinh hoa quyền lự', 2000, 'NXB Alpha Books', 100, '2022-03-01', 0, 20, 'Nguyễn Sỹ', 4),
(9, 'Paulo Coelho', 'MS009', 'Thực hư về chuyện xuất bản nhiều như những cuốn sách kinh thánh rất có thể chỉ là một chiêu trò của các nhà Marketing. Tuy nhiên không thể phủ nhận rằng, Nhà giả kim (tiếng anh là The Alchemist) là một cuốn sách đã vượt tầm thời đại và có sức cuốn hút rất riêng mà hiếm tác phẩm đương thời nào sánh được. Bởi vậy nên không ngạc nhiên khi tác phẩm này đã trở thành một trong những cuốn sách “best-seller” liên tục trong nhiều năm tại các trang bán sách online.', '10', 10.1, 'http://isach.info/images/story/cover/nha_gia_kim__paulo_coelho.jpg', 'Nhà giả kim', 2000, 'NXB Hội Nhà Văn', 100, '2020-01-01', 0, 30, 'Nguyễn Ba', 1);

INSERT INTO `app_role`  VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');
INSERT INTO `app_user`  VALUES 
(1, '2022-01-01', 'luuhoa0801@gmail.com', '12345', 'admin'),
(2, '2022-01-01', 'hoathuytien12369@gmail.com', '12345', 'user');


insert into `customer` values
(1, 'Đà Nẵng', '1994-10-11', 'Nam', 'Thnh Lnq', 09012365478, 0, 1),
(2, 'Đà Nẵng', '1994-10-11', 'Nam', 'Nguyễn Văn Bình', 09012365478, 0, 1),
(3, 'Đà Nẵng', '1994-10-11', 'Nam', 'Trần Văn Cường', 09012365478, 0, 1),
(4, 'Đà Nẵng', '1994-10-11', 'Nam', 'Nguyễn Văn Bình', 09012365478, 0, 1),
(5, 'Đà Nẵng', '1994-10-11', 'Nam', 'Trần Văn Cường', 09012365478, 0, 1),
(6, 'Đà Nẵng', '1994-10-11', 'Nam', 'Nguyễn Văn Bình', 09012365478, 0, 1),
(7, 'Đà Nẵng', '1994-10-11', 'Nam', 'Trần Văn Cường', 09012365478, 0, 1),
(8, 'Đà Nẵng', '1994-10-11', 'Nam', 'Nguyễn Văn Bình', 09012365478, 0, 1),
(9, 'Đà Nẵng', '1994-10-11', 'Nam', 'Trần Văn Cường', 09012365478, 0, 1),
(10, 'Đà Nẵng', '1994-10-11', 'Nam', 'Nguyễn Văn Bình', 09012365478, 0, 1),
(11, 'Đà Nẵng', '1994-10-11', 'Nam', 'Trần Văn Cường', 09012365478, 0, 1),
(12, 'Đà Nẵng', '1994-10-11', 'Nam', 'Nguyễn Văn Bình', 09012365478, 0, 1),
(13, 'Đà Nẵng', '1994-10-11', 'Nam', 'Trần Văn Cường', 09012365478, 0, 1);
insert into `cart` values
(1, '2022-09-09', 0, 1),
(2, '2022-09-09', 0, 2),
(3, '2022-09-09', 0, 3),
(4, '2022-09-09', 0, 1),
(5, '2022-09-09', 0, 1),
(6, '2022-09-09', 0, 2),
(7, '2022-09-09', 0, 3),
(8, '2022-09-09', 0, 1),
(9, '2022-09-09', 0, 2),
(10, '2022-09-09', 0, 3),
(11, '2022-09-09', 0, 1),
(12, '2022-09-09', 0, 2),
(13, '2022-09-09', 0, 3),
(14, '2022-09-09', 0, 1),
(15, '2022-09-09', 0, 2),
(16, '2022-09-09', 0, 3);
insert into `cart_detail` values
(1, 5, 1, 1),
(2, 15, 2, 1),
(3, 50, 1, 1),
(4, 5, 1, 1),
(5, 15, 2, 1),
(6, 50, 1, 1),
(7, 5, 1, 1),
(8, 15, 2, 1),
(9, 50, 1, 1),
(10, 5, 1, 1),
(11, 15, 2, 1),
(12, 50, 1, 1),
(13, 5, 1, 1),
(14, 15, 2, 1),
(15, 50, 1, 1),
(16, 5, 1, 1),
(17, 15, 2, 1),
(18, 50, 1, 1);
-- insert into `roles` values (1, 'ROLE_ADMIN', 0), (2, 'ROLE_USER', 0);
INSERT INTO `book_store`.`app_role` VALUES ('1', 'ROLE_NAME',0),(2, 'ROLE_USER', 0);

insert into `user_role` values
(1, 0, 1, 1),
(2, 0, 2, 2),
(3, 0, 1, 1),
(4, 0, 2, 2),
(5, 0, 1, 1),
(6, 0, 2, 2),
(7, 0, 1, 1),
(8, 0, 2, 2),
(9, 0, 1, 1),
(10, 0, 2, 2);
