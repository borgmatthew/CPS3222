package com.assignment.servlets;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
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

import com.assignment.DBObjects.User;
import com.assignment.functionalities.Registration;
import com.assignment.requests.UserRequest;

public class RegisterServletTest {

	private RegisterServlet registerServlet;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private HttpSession session;

	@Mock
	private PrintWriter out;

	@Mock
	private Registration register;
	
	@Mock
	private UserRequest userRequest;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		registerServlet = new RegisterServlet();
		registerServlet.setRegistration(register);
		registerServlet.setUserRequest(userRequest);
		
		doReturn(session).when(request).getSession();
		doReturn(out).when(response).getWriter();
		doReturn(true).when(userRequest).createUser(any(User.class));
	}

	@Test
	public void testInvalidRegistrationUserNotCreated() throws ServletException, IOException {
		//given
		doReturn(false).when(register).validateForm(anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString());
		//when
		registerServlet.doPost(request, response);
		//then
		verify(userRequest, never()).createUser(any(User.class));
	}

	@Test
	public void testValidRegistrationUserCreated() throws ServletException, IOException {
		//given
		doReturn(true).when(register).validateForm(anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString());
		//when
		registerServlet.doPost(request, response);
		//then
		verify(userRequest).createUser(any(User.class));
	}
}
