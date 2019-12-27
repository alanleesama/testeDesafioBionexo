package br.com.bionexo.teste.utils;

import org.springframework.stereotype.Component;

@Component
public class MathUtils {
	
	final static Integer EARTH_RADIUS_KM = 6371;
	
	
	public static Double calculoDistancia(Double latLocal, Double lonLocal, Double latUbs, Double lonUbs) {
		
		
		Double localLatToRad = Math.toRadians(latLocal);
		Double ubsLatToRad = Math.toRadians(latUbs);
		
		Double deltaLongitudeInRad = Math.toRadians(lonUbs - lonLocal);
		
		return Math.acos(Math.cos(localLatToRad) * Math.cos(ubsLatToRad)
				* Math.cos(deltaLongitudeInRad) + Math.sin(localLatToRad)
				* Math.sin(ubsLatToRad))
				* EARTH_RADIUS_KM;
	}
	

}
