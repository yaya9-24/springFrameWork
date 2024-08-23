package test.com.product.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
	private int num;
    private String pname;
    private String model;
    private int price;
    private int count;
    private String user_id;
    private String img_name;
    private MultipartFile file;
}
