package SpringMyMaven.pdfStyle;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdf {
	
	
  Document document = null;
  Rectangle one = null;	
  
  
  public static Font getGRAYFont(int fontSize, int style ){	    	
         final  Font FONT_GRAY  = new Font(FontFamily.TIMES_ROMAN, fontSize, style, BaseColor.GRAY);
         return FONT_GRAY;
        }
  
	public void createNewPdfFileInWriteMode(String dest) throws IOException, DocumentException { 
		this.document= new Document();
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		
		//set page number
		/*int n = document.getPageNumber();
		for (int i = 1; i <= n; i++) {
			 document.showTextAligned(new Paragraph(String.format("page %s of %s", i, n)),559, 806, i, TextAlignment.RIGHT, VerticalAlignment.TOP, 0);
			
        }*/
       }
	
	/*public Paragraph createParagraph(){
		Paragraph paragraph = new Paragraph();
		paragraph.
		
		
	}*/
	
	public void createTabel(int tableSizeInPercent, int numberOfColumn, int numberOfRow, String content){
		  PdfPTable pdfPTable = new PdfPTable(numberOfColumn);
		  pdfPTable.setWidthPercentage(tableSizeInPercent);
		  try {
			   for(int col =0; col<numberOfColumn; col++){
		           for(int row =0; row<numberOfRow ; row++){
			           PdfPCell pdfPCell = new PdfPCell(new Paragraph(content));
			           pdfPTable.addCell(pdfPCell);
		              }
			      }
			  document.add(pdfPTable);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		
	}
	
	public void writeOnDocument(int fontSize, int style, String fontFamilyName, String colour, String content,String alignment ,int topSpace_in_line,int bottomSpace_in_line){
		   if(colour.equals("GARY")){
			  // getGRAYFont(fontSize, style, fontFamilyName);
			   try {
			        Paragraph paragraph = new Paragraph(content, getGRAYFont(fontSize, style));
			        paragraph.setSpacingBefore(topSpace_in_line);
			        paragraph.setSpacingAfter(bottomSpace_in_line);
			        if(alignment.equals("CENTER"))
			           paragraph.setAlignment(Element.ALIGN_CENTER);
			        else if(alignment.equals("LEFT"))
			                paragraph.setAlignment(Element.ALIGN_LEFT);
			        else if(alignment.equals("RIGHT"))
			                paragraph.setAlignment(Element.ALIGN_RIGHT);
				    this.document.add(paragraph);
			       } catch (DocumentException e) {
				            // TODO Auto-generated catch block
				            e.printStackTrace();
			               }  
		     }	  	  
	     }
	
	public void addBlankLine(int numberOfBlankLine){
		for(int i=0; i<numberOfBlankLine; i++){
			try {
				 document.add( Chunk.NEWLINE );
			    } catch (DocumentException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			     }	
		   }
		
	    }
	
	public void setImage(float imgLength, float imgHight, float pos1, float pos2, String image) {
		Image img;
		try {
			 img = Image.getInstance(image);
			 img.scaleAbsolute(imgLength, imgHight);//image size
			 img.setAbsolutePosition(pos1, pos2);//image position
			 //img.scaleToFit(pos1, pos2);
			 this.document.add(img);
		    } catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		    }

	 }
	
	public void setPageSize(int lenght, int hight){		
		this.one = new Rectangle(lenght,hight);  
		this.document.setPageSize(one);         
	  }
	
	public void setMarginsSize(int top, int side){
		 document.setMargins(top, side, top, side);		
	   }
	
	public void setBorder(int borderSize){
		this.one.setBorder(Rectangle.BOX);		
		this.one.setBorderColor(BaseColor.BLACK);
		this.one.setBorderWidth(borderSize);
	}
	
	public void createPages(){
		try {
		     this.document.open();
             Paragraph p = new Paragraph(" ");
			 this.document.add(p);
		    } catch (DocumentException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		     }
	}
	
	public void closeDocument(){
		if(this.document!=null)
		this.document.close();	
	}
	
	

}


/* F
public static final int COURIER = 0;
public static final int HELVETICA = 1;
public static final int TIMES_NEW_ROMAN = 2;
public static final int SYMBOL = 3;
public static final int ZAPFDINGBATS = 4;*/

/*public static final int NORMAL		= 0;
public static final int BOLD		= 1;
public static final int ITALIC		= 2;
public static final int UNDERLINE	= 4;
public static final int STRIKETHRU	= 8;
public static final int BOLDITALIC	= BOLD | ITALIC;*/


//**********************font class**********************************
//https://sourceforge.net/p/itext/itextpdf/ci/a79a0cb1f1c25fb3fe651a3e9b0ac9b6d67879ef/tree/itext/src/com/lowagie/text/Font.java#l67
//*********************************************************************
//http://developers.itextpdf.com/examples/itext5-building-blocks/page-size
//http://www.vogella.com/tutorials/JavaPDF/article.html
//http://howtodoinjava.com/apache-commons/create-pdf-files-in-java-itext-tutorial/#create_list