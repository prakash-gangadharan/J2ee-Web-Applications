package com.apache.cxf.queryparam.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/player")
public interface IPlayerService {
	
	// http://localhost:8080/ApacheCXF-QueryParam/services/player/welcome/Dravid
	@GET
	@Path("/welcome/{name}")
	public Response welcomePlayerUsingPathParam(@PathParam("name") String playerName);

	// http://localhost:8080/ApacheCXF-QueryParam/services/player/playerinfo/Sachin/41/200
	@GET
	@Path("playerinfo/{name}/{age}/{matches}")
	public Response getPlayerInfoUsingPathParam(
			@PathParam("name") String playerName,
			@PathParam("age") int age,
			@PathParam("matches") int matches);
	
	

	// http://localhost:8080/ApacheCXF-QueryParam/services/player/welcome?name=Gilchrist
	@GET
	@Path("/welcome")
	public Response welcomePlayer(@QueryParam("name") String playerName);

	// http://localhost:8080/ApacheCXF-QueryParam/services/player/playerinfo?name=Pietersen&age=33&matches=104
	@GET
	@Path("/playerinfo")
	public Response getPlayerInfo(
			@QueryParam("name") String playerName, 
			@QueryParam("age") int age, 
			@QueryParam("matches") int matches);
}