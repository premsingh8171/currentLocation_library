/**
 * Created by Er.prem singh on 16/12/2020.
 * https://www.linkedin.com/in/prem-singh-daksha-82az/
 */

package com.premsinghdaksha.currentlocation_library;

import android.content.Context;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class GetLocFromLatLong {

    private static String Address = "", City = "", State = "", Country = "", Locality = "", Pincode = "",
            mAdminArea = "", mSubAdminArea = "", mSubLocality = "", mThoroughfare = "", mSubThoroughfare = "",
            mCountryCode = "", mPhone = "", mUrl = "", mFeatureName = "";
    private Context context;

    public GetLocFromLatLong(Context context) {
        this.context = context;
    }

    public String getLocation_(final double latitude, final double longitude) {


        final Geocoder geocoder = new Geocoder(this.context, Locale.getDefault());
        try {

            final List<android.location.Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
            if (addressList != null && addressList.size() > 0) {
                android.location.Address address = addressList.get(0);

                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    Address += (address.getAddressLine(i)) + (",");
                }
                try {

                    if (Address != null) {
                        Address = Address.substring(0, Address.length() - 1);
                    } else {
                        Address = "";
                    }

                    if (address.getLocality() != null) {
                        City = address.getLocality();
                    } else {
                        City = "";
                    }

                    if (address.getAdminArea() != null) {
                        State = address.getAdminArea();
                    } else {
                        State = "";
                    }

                    if (address.getCountryName() != null) {
                        Country = address.getCountryName();
                    } else {
                        Country = "";
                    }

                    if (address.getLocality() != null) {
                        Locality = address.getLocality();
                    } else {
                        Locality = "";
                    }

                    if (address.getPostalCode() != null) {
                        Pincode = address.getPostalCode();
                    } else {
                        Pincode = "";

                    }

                    if (address.getAdminArea() != null) {
                        mAdminArea = address.getAdminArea();
                    } else {
                        mAdminArea = "";

                    }

                    if (address.getSubAdminArea() != null) {
                        mSubAdminArea = address.getSubAdminArea();
                    } else {
                        mSubAdminArea = "";

                    }
                    if (address.getSubLocality() != null) {
                        mSubLocality = address.getSubLocality();
                    } else {
                        mSubLocality = "";

                    }

                    if (address.getThoroughfare() != null) {
                        mThoroughfare = address.getPostalCode();
                    } else {
                        mThoroughfare = "";

                    }

                    if (address.getSubThoroughfare() != null) {
                        mSubThoroughfare = address.getSubThoroughfare();
                    } else {
                        mSubThoroughfare = "";

                    }

                    if (address.getPhone() != null) {
                        mPhone = address.getPhone();
                    } else {
                        mPhone = "";
                    }

                    if (address.getUrl() != null) {
                        mUrl = address.getUrl();
                    } else {
                        mUrl = "";

                    }
                    if (address.getFeatureName() != null) {
                        mFeatureName = address.getFeatureName();
                    } else {
                        mFeatureName = "";

                    }

                } catch (Exception ex) {
                    if (addressList.get(0).getAddressLine(0) != null) {
                        Address = addressList.get(0).getAddressLine(0);//// If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                    } else {
                        Address = "";
                    }

                    if (Address != null) {
                        Address = Address.substring(0, Address.length() - 1);
                    } else {
                        Address = "";
                    }

                    if (address.getLocality() != null) {
                        City = address.getLocality();
                    } else {
                        City = "";
                    }

                    if (address.getAdminArea() != null) {
                        State = address.getAdminArea();
                    } else {
                        State = "";
                    }

                    if (address.getCountryName() != null) {
                        Country = address.getCountryName();
                    } else {
                        Country = "";
                    }

                    if (address.getLocality() != null) {
                        Locality = address.getLocality();
                    } else {
                        Locality = "";
                    }

                    if (address.getPostalCode() != null) {
                        Pincode = address.getPostalCode();
                    } else {
                        Pincode = "";

                    }

                    if (address.getAdminArea() != null) {
                        mAdminArea = address.getAdminArea();
                    } else {
                        mAdminArea = "";

                    }

                    if (address.getSubAdminArea() != null) {
                        mSubAdminArea = address.getSubAdminArea();
                    } else {
                        mSubAdminArea = "";

                    }
                    if (address.getSubLocality() != null) {
                        mSubLocality = address.getSubLocality();
                    } else {
                        mSubLocality = "";

                    }

                    if (address.getThoroughfare() != null) {
                        mThoroughfare = address.getPostalCode();
                    } else {
                        mThoroughfare = "";

                    }

                    if (address.getSubThoroughfare() != null) {
                        mSubThoroughfare = address.getSubThoroughfare();
                    } else {
                        mSubThoroughfare = "";

                    }

                    if (address.getPhone() != null) {
                        mPhone = address.getPhone();
                    } else {
                        mPhone = "";
                    }

                    if (address.getUrl() != null) {
                        mUrl = address.getUrl();
                    } else {
                        mUrl = "";

                    }
                    if (address.getFeatureName() != null) {
                        mFeatureName = address.getFeatureName();
                    } else {
                        mFeatureName = "";

                    }

                    // Toast.makeText(context, "Exception", Toast.LENGTH_SHORT).show();

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

    public String getAdminArea() {
        return mAdminArea;
    }

    public String getSubAdminArea() {
        return mSubAdminArea;
    }

    public String getSubLocality() {
        return mSubLocality;
    }

    public String getThoroughfare() {
        return mThoroughfare;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getFeatureName() {
        return mFeatureName;
    }

    public String getSubThoroughfare() {
        return mSubThoroughfare;
    }

    //----------------------------check gps status---------

}
