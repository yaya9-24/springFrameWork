package test.com.board.model;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int num;
    private String title;
    private String content;
    private String writer;
    private Date wdate;
}
