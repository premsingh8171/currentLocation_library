# currentLocation_library
get current location 

<img src="" width="300" height="550" />


## Installation

-  Add the following to your project level `build.gradle`:
 
```gradle
allprojects {
	repositories {
	
		maven {  url 'https://jitpack.io' }
	}
}
```
  -  Add this to your app `build.gradle`:
 
```gradle
dependencies {

     implementation 'com.github.premsingh8171:currentLocation_library:1.0.1' 
}
```

## Using 

```java 

    private TextView select_tv;
    private GetAddFromLatLong getAddFromLatLong;
    private TrackGPSLocation trackGPSLocation;
    private int checkPermition = 0;
    private static final int MY_PERMISSIONS_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        select_tv = findViewById(R.id.select_tv);
        address = findViewById(R.id.address);
        checkPermission();
        trackGPSLocation = new TrackGPSLocation(MainActivity.this);
        getLocFromLatLong = new GetLocFromLatLong(MainActivity.this);
        getLocFromLatLong.getLocation_(trackGPSLocation.getLatitude(), trackGPSLocation.getLongitude());

        findViewById(R.id.selectadd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkPermition == 1) {
                    //here we passes the lat long by sing trackGPSAddress
                    String value = getLocFromLatLong.getLocality();

//                    String value2 = getLocFromLatLong.getAddress();
//                    String value3 = getLocFromLatLong.getCountry();
//                    String value4 = getLocFromLatLong.getLocality();
//                    String value5 = getLocFromLatLong.getPincode();
//                    String value6 = getLocFromLatLong.getAdminArea();
//                    String value7 = getLocFromLatLong.getCountryCode();
//                    String value8 = getLocFromLatLong.getFeatureName();
//                    String value9 = getLocFromLatLong.getState();
//                    String value10 = getLocFromLatLong.getPhone();
//                    String value11 = getLocFromLatLong.getSubLocality();
//                    String value12 = getLocFromLatLong.getUrl();

                    //set current address
                    select_tv.setText(value);

                } else {
                    checkPermission();
                }
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermition == 1) {
                    address.setText(getLocFromLatLong.getAddress());
                } else {
                    checkPermission();
                }
            }
        });

    }
```
## Check permission of location

```
protected void checkPermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
            ) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_CODE);

            } else {

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, MY_PERMISSIONS_REQUEST_CODE
                );
            }
        } else {
            checkPermition = 1;
        }
        Log.d("trackGPSLoca", String.valueOf(checkPermition));

    }
```

## here we get location permition result(permition enable or disable)

```java
   @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CODE: {
                if ((grantResults[0] == 0)) {
                    checkPermition = 1;
                } else {
                    checkPermition = 0;
                }
                return;
            }
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        trackGPSLocation = new TrackGPSLocation(MainActivity.this);
        getLocFromLatLong = new GetLocFromLatLong(MainActivity.this);
        getLocFromLatLong.getLocation_(trackGPSLocation.getLatitude(), trackGPSLocation.getLongitude());

    }
```

<h2>Created and maintained by:</h2>
<p>Er.Prem singh daksha  premsingh8171@gmail.com</p>
<p><a href="https://www.linkedin.com/in/prem-singh-daksha-82az/"> <img src="https://github.com/anitaa1990/DeviceInfo-Sample/blob/master/media/linkedin-icon.png" alt="Linkedin" style="max-width:100%;"> </a></p>
