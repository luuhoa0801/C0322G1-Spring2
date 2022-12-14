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
        String subject = "H??y x??c th???c email c???a b???n";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verify-reset-password/" + userName;


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("sangnguyenjp97@gmail.com", "CODE GYM");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin ch??o " + userName + " ,<p>" + "<p> Nh???n v??o link sau ????? x??c th???c email c???a b???n:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link X??c th???c( nh???n v??o ????y)!</a></h3>" +
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
        String subject = "Th??ng Tin Thanh To??n";
        String mailContent = "";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("luuhoa0801@gmail.com", "Book Store");
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
                        "<h2 style=\"text-align: center\">C???m ??n b???n ???? ?????t h??ng t???i BookStore</h2>\n" +
                        "<h2>Xin ch??o " + cart.getCustomer().getName() + "</h2>\n" +
                        "<p>BookStore ???? nh???n ???????c y??u c???u ?????t h??ng c???a b???n v?? ??ang x??? l?? nh??. B???n s??? nh???n ???????c th??ng b??o ti???p theo khi ????n h??ng ???? s???n s??ng ???????c giao.</p>\n" +
                        "<h2 style=\"text-align: center\">T??nh tr???ng ????n h??ng</h2>\n" +
                        "<p><strong>*L??u ?? nh??? cho b???n:</strong> B???n ch??? n??n nh???n h??ng khi tr???ng th??i ????n h??ng l?? <strong>'??ang giao h??ng'</strong> v?? nh??? ki???m tra M?? ????n h??ng, Th??ng tin ng?????i g???i v?? M?? v???n ????n ????? nh???n ????ng ki???n h??ng nh??.</p>\n" +
                "<h3>????n h??ng ???????c giao ?????n:</h3>\n" +
                "<p>T??n: " + cart.getCustomer().getName() + "</p>\n" +
                "<p>?????a ch???: " + cart.getCustomer().getAddress() + "</p>\n" +
                "<p>??i???n tho???i: 0" + cart.getCustomer().getPhone() + "</p>\n" +
                "<p>Email: " + cart.getCustomer().getEmail() + "</p>\n" +
                "<h3>Chi ti???t ki???n h??ng</h3>\n" +
                "\n" +
                "<table>\n" +
                "  <tr style='background-color: grey; color: white'>\n" +
                "    <th>STT</th>\n" +
                "    <th>T??n S??ch</th>\n" +
                "    <th>S??? L?????ng</th>\n" +
                "    <th>Gi??</th>\n" +
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
                            "<td>" + decimalFormat.format(Math.round(cartDetail.getBook().getPrice())) + " VN??</td>\n" +
                            "</tr>\n";
            sum += cartDetail.getBook().getPrice() * cartDetail.getQuantity();
            index++;
        }
        int ship = 10000;
        int totalMoney = sum + ship;
        mailContent +=  "<tr>" +
                "<td rowspan=\"3\" colspan=\"2\"></td>"+
                "<td style='text-align: right'>Th??nh ti???n: </td>" +
                "<td >" + decimalFormat.format(sum) + " VN??</td>" +
                "</tr>" +
                "<tr>" +
                "<td  style='text-align: right'>Ph?? v???n chuy???n: </td>" +
                "<td  >" + decimalFormat.format(ship) + " VN??</td>" +
                "</tr>" +
                "<tr>" +
                "<td  style='text-align: right'>T???ng c???ng: </td>" +
                "<td  style=\"color: #dc3545;font-weight: bold\">" + decimalFormat.format(totalMoney) + " VN??</td>" +
                "</tr>" +
                "</table>" +
                "\n" +
                "</body>\n" +
                "</html>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }
}
