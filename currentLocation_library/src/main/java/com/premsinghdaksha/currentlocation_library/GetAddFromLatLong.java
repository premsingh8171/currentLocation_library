package com.premsinghdaksha.currentlocation_library;

import android.content.Context;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class GetAddFromLatLong {

    private static String Address, City, State, Country, Locality, Pincode;
    private Context context;

    public GetAddFromLatLong(Context context) {
        this.context = context;
    }

    public String SaveLocationData(final double latitude, final double longitude) {
        Address = "";
        City = "";
        State = "";
        Country = "";
        Locality = "";
        Pincode = "";
        final Geocoder geocoder = new Geocoder(this.context, Locale.getDefault());
        try {

            final List<android.location.Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
            if (addressList != null && addressList.size() > 0) {
                android.location.Address address = addressList.get(0);

                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    Address += (address.getAddressLine(i)) + (",");
                }
                try {
                    Address = Address.substring(0, Address.length() - 1);
                    City = address.getLocality();
                    if (City == null) {
                        City = "";
                    }
                    State = address.getAdminArea();
                    if (State == null) {
                        State = "";
                    }
                    Country = address.getCountryName();

                    if (Country == null) {
                        Country = "";
                    }
                    Locality = address.getLocality();
                    if (Locality == null) {
                        Locality = "";
                    }

                    Pincode = address.getPostalCode();
                    if (Pincode == null) {
                        Pincode = "";
                    }

                } catch (Exception ex) {
                    Address = addressList.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                    City = address.getLocality();
                    if (City == null) {
                        City = "";
                    }
                    State = address.getAdminArea();
                    if (State == null) {
                        State = "";
                    }
                    Country = address.getCountryName();
                    if (Country == null) {
                        Country = "";
                    }
                    Locality = address.getLocality();
                    if (Locality == null) {
                        Locality = "";
                    }

                    Pincode = address.getPostalCode();
                    if (Pincode == null) {
                        Pincode = "";
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {


        }
        return null;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;

    }

    public String getState() {
        return State;
    }

    public String getCountry() {
        return Country;
    }

    public String getLocality() {
        return Locality;
    }

    public String getPincode() {
        return Pincode;
    }

    //----------------------------check gps status---------

}
