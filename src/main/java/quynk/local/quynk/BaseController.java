package quynk.local.quynk;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class BaseController {
    private final JdbcTemplate JdbcTemplate;

    public BaseController(JdbcTemplate JdbcTemplate) {
        this.JdbcTemplate = JdbcTemplate;
    }

    @RequestMapping("/test")
    public String test() {

        String sql = "CREATE TABLE IF NOT EXISTS test_table (" +
        "id INT PRIMARY KEY, " + 
        "name VARCHAR(255) NOT NULL" + ")";

        JdbcTemplate.execute(sql);
        return "Đã tạo bảng thành công!";
    }
}