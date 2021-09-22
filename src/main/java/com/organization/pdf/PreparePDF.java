package com.organization.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.organization.enitity.Employee;
import com.organization.service.EmployeeService;

@Component
public class PreparePDF {

	private List<Employee> listUsers;
	@Autowired
	private EmployeeService employeeService;
	
	public PreparePDF(List<Employee> listUsers) {
		this.listUsers = listUsers;
	}

	private void writeTableHeader(PdfPTable table) {

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("User ID", font));

		table.addCell(cell);

		/*cell.setPhrase(new Phrase("E-mail", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Full Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Roles", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Enabled", font));
		table.addCell(cell);*/
	}

	private void writeTableData(PdfPTable table) {
		listUsers=employeeService.getEmployees();
		for (Employee user : listUsers) {
			table.addCell(String.valueOf(user.getId()));
			/*table.addCell(user.getCompanyName());
			table.addCell(user.getEmailId());
			table.addCell(user.getOrgId().toString());
			// table.addCell(String.valueOf(user.isEnabled())); */

			table.getRows().forEach(a -> System.out.print(a));
		}
	}

	public List<Employee> extracted(List<Employee> employees) {
		return employees;
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Users", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		
		document.close();

	}

}
