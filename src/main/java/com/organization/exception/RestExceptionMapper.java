/*
 * package com.organization.exception;
 * 
 * import javax.ws.rs.core.Response; import javax.ws.rs.ext.ExceptionMapper;
 * import javax.ws.rs.ext.Provider;
 * 
 * @Provider public class RestExceptionMapper implements
 * ExceptionMapper<Exception>{
 * 
 * @Override public Response toResponse(Exception exception) {
 * 
 * if(exception instanceof ValidationException) { return Response.ok(new
 * ValidationException(exception.getMessage())).build();
 * 
 * } return null; }
 * 
 * }
 */