package br.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * Classe responsavel por conter os atributos do Objeto Leituras
 * 
 */
@XmlRootElement
public class Leituras {
	
    
         //private Integer id;
	 private String nome;
	 private String sensor1;
	 private String sensor2;
         private String sensor3;
	
        
	@Override
	public String toString() {
		return "Código [lixeira=" + getNome() + ", sensor1=" + sensor1 + ", sensor2=" + sensor2 + ", sensor3=" + sensor3 + "]";
	}
	
        /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sensor1
     */
    public String getSensor1() {
        return sensor1;
    }

    /**
     * @param sensor1 the sensor1 to set
     */
    public void setSensor1(String sensor1) {
        this.sensor1 = sensor1;
    }

    /**
     * @return the sensor2
     */
    public String getSensor2() {
        return sensor2;
    }

    /**
     * @param sensor2 the sensor2 to set
     */
    public void setSensor2(String sensor2) {
        this.sensor2 = sensor2;
    }

    /**
     * @return the sensor3
     */
    public String getSensor3() {
        return sensor3;
    }

    /**
     * @param sensor3 the sensor3 to set
     */
    public void setSensor3(String sensor3) {
        this.sensor3 = sensor3;
    }
	
	
}
