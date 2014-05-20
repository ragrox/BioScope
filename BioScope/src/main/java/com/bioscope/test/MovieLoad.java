package com.bioscope.test;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.bioscope.config.SpringMongoConfig;
import com.bioscope.domain.movieService.ListReviews;
import com.bioscope.domain.movieService.Movie;
import com.bioscope.domain.movieService.Review;

public class MovieLoad {
	public static void main(String[] args) throws Exception{

		// For XML
		//ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");

		// For Annotation
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		Movie movie = new Movie();
		try
		{
			FileInputStream file = new FileInputStream(new File("movieList.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			Review review =null;

			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			int len = sheet.getLastRowNum();
			System.out.println(len);
			for ( int i = 1 ; i < sheet.getLastRowNum();i++){
				movie = new Movie();
				XSSFRow row  = sheet.getRow(i);
				if( row.getCell(0) != null && !"".equals(row.getCell(0))){
					movie.setMovieName(row.getCell(0).getStringCellValue());
					movie.setMovieDescription(row.getCell(1).getStringCellValue());
					review = new Review();
					review.setUserName("pranit");
					review.setReviewDescription("Test Value while loading");
					movie.setRating(row.getCell(3).getRawValue());
					//System.out.println(row.getCell(2).getStringCellValue());
					String split[] = row.getCell(2).getStringCellValue().split(",");
					ArrayList<String> list = new ArrayList<String>();
					for( String cast : split){
						list.add(cast);
					}
					movie.setCasting(list);
					movie.setGenre(row.getCell(4).getRawValue());
					movie.setYear(row.getCell(5).getRawValue());
					ListReviews listReviews = new ListReviews();
					List<Review> reviews = listReviews.getReview();
					reviews.add(review);
					movie.setListReviews(listReviews);
					mongoOperation.save(movie);
				}
			}

		}catch(Exception e ){
			e.printStackTrace();
			System.out.println("Error : " + e.toString());
		}
	}
}
