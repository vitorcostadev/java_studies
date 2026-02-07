package desafios.sistemaDeCadastroDePet.domain;

import java.security.InvalidParameterException;

public class AddressWhoFoundPet {
    private String numberOfHome;
    private String cityOfHome;
    private String roadOfHome;

    public AddressWhoFoundPet(String numberOfHome, String cityOfHome, String roadOfHome) throws InvalidParameterException{
        if(numberOfHome == null || numberOfHome.isEmpty()){
            throw new InvalidParameterException("O parametro 'numberOfHome' não pode ser vazio.");
        }
        if(cityOfHome == null || cityOfHome.isEmpty()){
            throw new InvalidParameterException("O parametro 'cityOfHome' não pode ser vazio.");
        }
        if(roadOfHome == null || roadOfHome.isEmpty()){
            throw new InvalidParameterException("O parametro 'roadOfHome' não pode ser vazio.");
        }
        this.numberOfHome = numberOfHome;
        this.cityOfHome = cityOfHome;
        this.roadOfHome = roadOfHome;
    }

    public void setNumberOfHome(String numberOfHome) throws InvalidParameterException{
        if(numberOfHome == null || numberOfHome.isEmpty()){
            throw new InvalidParameterException("O parametro 'numberOfHome' não pode ser vazio.");
        }
        this.numberOfHome = numberOfHome;
    }

    public void setCityOfHome(String cityOfHome) throws InvalidParameterException{
        if(cityOfHome == null || cityOfHome.isEmpty()){
            throw new InvalidParameterException("O parametro 'cityOfHome' não pode ser vazio.");
        }
        this.cityOfHome = cityOfHome;
    }

    public void setRoadOfHome(String roadOfHome) throws InvalidParameterException{
        if(roadOfHome == null || roadOfHome.isEmpty()){
            throw new InvalidParameterException("O parametro 'roadOfHome' não pode ser vazio.");
        }
        this.roadOfHome = roadOfHome;
    }

    public String getCityOfHome() {
        return cityOfHome;
    }

    public String getNumberOfHome() {
        return numberOfHome;
    }

    public String getRoadOfHome() {
        return roadOfHome;
    }


}
