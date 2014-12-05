package com.assignment.servlets;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assignment.functionalities.Betting;

public class BettingServletTest {
	
	private BettingServlet bettingServlet;
	
	@Mock
	private Betting bettingImpl;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpServletResponse response;
	
	@Mock
	private HttpSession session;
	
	@Mock
	private PrintWriter out;
	
	private String invalidAmountError = "{ \"success\" : \"false\" , \"message\" : \"Invalid amount\"}";
	private String noErrors = "{ \"success\" : \"true\" , \"message\" : \"Bet placed successfully\"}";
	private String errorOccurs = "{ \"success\" : \"false\" , \"message\" : \"An error occured. Please try again.\"}";
	private String invalidRisk = "{ \"success\" : \"false\" , \"message\" : \"Invalid risk\"}";
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		bettingServlet = new BettingServlet();
		bettingServlet.setBettingImpl(bettingImpl);
		
		doReturn(out).when(response).getWriter();
		doReturn(session).when(request).getSession();
		doNothing().when(bettingImpl).addBet(anyString(), anyDouble(), anyString());
	}

	@Test
	public void testNotLoggedInVerifyRedirection() throws IOException, ServletException {
		//given
		doReturn(null).when(session).getAttribute("user");
		//when
		bettingServlet.doPost(request, response);
		//then
		verify(response).sendRedirect("index.jsp");
	}

	@Test
	public void testValidateBetNoErrors() throws ServletException, IOException{
		//given
		doReturn("user").when(session).getAttribute("user");
		doReturn("Low").when(request).getParameter("betrisk");
		doReturn("1.0").when(request).getParameter("amm");
		doReturn(true).when(bettingImpl).validateBets(anyString(), anyString(), anyDouble());
		doReturn("Bet placed successfully").when(bettingImpl).getMessage();
		//when
		bettingServlet.doPost(request, response);
		//then
		verify(out).println(noErrors);
	}
	
	@Test
	public void testValidateBetNumberFormatExceptionOccurs() throws ServletException, IOException{
		//given
		doReturn("user").when(session).getAttribute("user");
		doReturn("Low").when(request).getParameter("betrisk");
		doReturn("abc").when(request).getParameter("amm");
		doReturn(true).when(bettingImpl).validateBets(anyString(), anyString(), anyDouble());
		//when
		bettingServlet.doPost(request, response);
		//then
		verify(out).println(invalidAmountError);
	}
	
	@Test
	public void testValidateBetNullPointerExceptionOccurs() throws ServletException, IOException{
		//given
		doReturn("user").when(session).getAttribute("user");
		doReturn("Low").when(request).getParameter("betrisk");
		doReturn(null).when(request).getParameter("amm");
		doReturn(true).when(bettingImpl).validateBets(anyString(), anyString(), anyDouble());
		//when
		bettingServlet.doPost(request, response);
		//then
		verify(out).println(invalidAmountError);
	}
	
	@Test
	public void testValidateBetInvalidBet() throws ServletException, IOException{
		//given
		doReturn("usr").when(session).getAttribute("user");
		doReturn("Low").when(request).getParameter("betrisk");
		doReturn("1.0").when(request).getParameter("amm");
		doReturn(false).when(bettingImpl).validateBets(anyString(), anyString(), anyDouble());
		doReturn("An error occured. Please try again.").when(bettingImpl).getMessage();
		//when
		bettingServlet.doPost(request, response);
		//then
		verify(out).println(errorOccurs);
	}
	
	@Test
	public void testValidateBetRiskIsNull() throws ServletException, IOException{
		//given
		doReturn("usr").when(session).getAttribute("user");
		doReturn(null).when(request).getParameter("betrisk");
		doReturn("1.0").when(request).getParameter("amm");
		doReturn(true).when(bettingImpl).validateBets(anyString(), anyString(), anyDouble());
		//when
		bettingServlet.doPost(request, response);
		//then
		verify(out).println(invalidRisk);
	}
}
