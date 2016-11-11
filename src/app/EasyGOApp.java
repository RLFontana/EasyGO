package app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import controller.EasyGOWS;

public class EasyGOApp extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	public static String path;
	
	public EasyGOApp(){
		this.singletons.add(new EasyGOWS());
	}
	
	@Override
	public Set<Class<?>> getClasses(){
		return this.empty;
	}
	
	@Override
	public Set<Object> getSingletons(){
		return this.singletons;
	}
}
