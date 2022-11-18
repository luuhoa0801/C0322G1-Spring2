package com.example.book.service.impl;

import com.example.book.dTo.CartDetailDto;
import com.example.book.entity.AppUser;
import com.example.book.entity.Cart;
import com.example.book.entity.CartDetail;
import com.example.book.repository.CartDetailRepository;
import com.example.book.repository.UserRepository;
import com.example.book.repository.UserRoleRepository;
import com.example.book.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public AppUser findByName(String name) {
        return userRepository.findAppUserByName(name);
    }


    @Override
    public String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException {
        String user = userRepository.existsByUserName(username);
        AppUser appUser = userRepository.findAppUserByName(username);
        if (user != null) {
            sendVerificationEmailForResetPassWord(username, appUser.getEmail());
        }
        return user;
    }

    @Override
    public void saveNewPassword(String password, String name) {
        userRepository.saveNewPassword(password, name);
    }


    public void sendVerificationEmailForResetPassWord(String userName, String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Hãy xác thực email của bạn";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verify-reset-password/" + userName;


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("sangnguyenjp97@gmail.com", "CODE GYM");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + userName + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link Xác thực( nhấn vào đây)!</a></h3>" +
                "<p>CODE GYM</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }


    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void save(AppUser appUser) {
        if (userRepository.findAppUserByName(appUser.getUsername()) != null) {
            return;
        }
        appUser.setPassword(passwordEncoder().encode(appUser.getPassword()));
        userRepository.save(appUser);
        userRoleRepository.save(appUser.getId());
    }

    @Override
    public void createRegister(AppUser appUser) {
        userRepository.save(appUser.getUsername(), appUser.getPassword(), appUser.getEmail());
    }


    @Override
    public Integer findMaxId() {
        return userRepository.findMaxId();
    }

    @Override
    public Optional<AppUser> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void edit(AppUser appUser) {
        userRepository.edit(appUser.getUsername(), appUser.getPassword(), appUser.getEmail(), appUser.getId());
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }


    @Override
    public Boolean existsUsername(String username) {
        return username.equals(userRepository.existsUsername(username));
    }


    @Override
    public Boolean existsEmail(String email) {
        return email.equals(userRepository.existsEmail(email));
    }



    @Override
    public void sendEmail(Cart cart, List<CartDetailDto> list) throws MessagingException, UnsupportedEncodingException {
        String subject = "Thông Tin Thanh Toán";
        String mailContent = "";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("dotronghoang95@gmail.com", "Book Store");
        helper.setTo(cart.getCustomer().getEmail());
        helper.setSubject(subject);

        mailContent +=
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "<style>\n" +
                        "table {\n" +
                        "  border-collapse: collapse;\n" +
                        "  width: 100%;\n" +
                        "}\n" +
                        "\n" +
                        "th, td {\n" +
                        "  padding: 8px;\n" +
                        "  text-align: left;\n" +
                        "  border-bottom: 1px solid #DDD;\n" +
                        "}\n" +
                        "\n" +
                        "</style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "<h2 style=\"text-align: center\">Cảm ơn bạn đã đặt hàng tại BookStore</h2>\n" +
                        "<h2>Xin chào " + cart.getCustomer().getName() + "</h2>\n" +
                        "<p>BookStore đã nhận được yêu cầu đặt hàng của bạn và đang xử lý nhé. Bạn sẽ nhận được thông báo tiếp theo khi đơn hàng đã sẵn sàng được giao.</p>\n" +
                        "<h2 style=\"text-align: center\">Tình trạng đơn hàng</h2>\n" +
                        "<p><strong>*Lưu ý nhỏ cho bạn:</strong> Bạn chỉ nên nhận hàng khi trạng thái đơn hàng là <strong>'Đang giao hàng'</strong> và nhớ kiểm tra Mã đơn hàng, Thông tin người gửi và Mã vận đơn để nhận đúng kiện hàng nhé.</p>\n" +
                "<h3>Đơn hàng được giao đến:</h3>\n" +
                "<p>Tên: " + cart.getCustomer().getName() + "</p>\n" +
                "<p>Địa chỉ: " + cart.getCustomer().getAddress() + "</p>\n" +
                "<p>Điện thoại: 0" + cart.getCustomer().getPhone() + "</p>\n" +
                "<p>Email: " + cart.getCustomer().getEmail() + "</p>\n" +
                "<h3>Chi tiết kiện hàng</h3>\n" +
                "\n" +
                "<table>\n" +
                "  <tr style='background-color: grey; color: white'>\n" +
                "    <th>STT</th>\n" +
                "    <th>Tên Sách</th>\n" +
                "    <th>Số Lượng</th>\n" +
                "    <th>Giá</th>\n" +
                "  </tr>\n";
        int sum = 0;
        int index = 1;
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
        for (CartDetail cartDetail : cartDetailRepository.findCartDetail(cart.getId())) {
            mailContent +=
                    "  <tr>\n" +
                            "<td>" + index + "</td>\n" +
                            "<td>" + cartDetail.getBook().getName() + "</td>\n" +
                            "<td>" + cartDetail.getQuantity() + "</td>\n" +
                            "<td>" + decimalFormat.format(Math.round(cartDetail.getBook().getPrice())) + " VNĐ</td>\n" +
                            "</tr>\n";
            sum += cartDetail.getBook().getPrice() * cartDetail.getQuantity();
            index++;
        }
        int ship = 10000;
        int totalMoney = sum + ship;
        mailContent +=  "<tr>" +
                "<td rowspan=\"3\" colspan=\"2\"></td>"+
                "<td style='text-align: right'>Thành tiền: </td>" +
                "<td >" + decimalFormat.format(sum) + " VNĐ</td>" +
                "</tr>" +
                "<tr>" +
                "<td  style='text-align: right'>Phí vận chuyển: </td>" +
                "<td  >" + decimalFormat.format(ship) + " VNĐ</td>" +
                "</tr>" +
                "<tr>" +
                "<td  style='text-align: right'>Tổng cộng: </td>" +
                "<td  style=\"color: #dc3545;font-weight: bold\">" + decimalFormat.format(totalMoney) + " VNĐ</td>" +
                "</tr>" +
                "</table>" +
                "\n" +
                "</body>\n" +
                "</html>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }
}
