package java8.homework.two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//know during which period of time load is high

public class ExcersiseTwo {
	
	public static void main(String[] args) 
	   {

		String fileName = "src\\main\\resources\\Book1.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.filter(x->x.contains("VISITID")).map(x->
			{   LocalDateTime dateTime = LocalDateTime.parse(x.substring(0, 16));//fetch the date

				return dateTime.getHour()+":"+dateTime.getMinute();//return hour and minut
			}
					).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))//counts the frequency of every element.
		      .entrySet()
		      .stream()
		      .max(Map.Entry.comparingByValue()) //looks up the entry with the highest frequency
		      .ifPresent(x->System.out.println(x)); 
//			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	   }
/*
	private static void m1() {
		
		  
			File f = new File("C:\\Users\\osvae\\Desktop\\Book1.xlsx");
			List<String> dates= new ArrayList<>();
			InputStream inp;
			try {
				inp = new FileInputStream(f);
				Workbook wb = WorkbookFactory.create(inp);
				Sheet sh = wb.getSheetAt(0);
				int iRow = 1;
				Row row = sh.getRow(iRow); 
				while (row != null) {
					Cell cell = row.getCell(2);			
//					System.out.println(cell.getStringCellValue());
//					formatter6.parse(cell.getStringCellValue());  
					dates.add(cell.getStringCellValue());
					iRow++;
					row = sh.getRow(iRow);
				}
				
				
				
				dates.stream()
			      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))//counts the frequency of every element.
			      .entrySet()
			      .stream()
			      .max(Map.Entry.comparingByValue()) //looks up the entry with the highest frequency
			      .ifPresent(x->System.out.println(x)); 

			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			   
	}*/

}
