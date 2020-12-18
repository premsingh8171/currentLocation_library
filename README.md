# currentLocation_library
get current location 

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

     implementation 'com.github.premsingh8171:currentLocation_library:1.0.0' 
}
```
## Using onClick

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
        checkPermission();
        getAddFromLatLong = new GetAddFromLatLong(MainActivity.this);

        findViewById(R.id.selectadd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //here we passes the lat long by sing trackGPSAddress
                getAddFromLatLong.SaveLocationData(trackGPSLocation.getLatitude(), trackGPSLocation.getLongitude());
                String value = getAddFromLatLong.getCity();
                String value2 = getAddFromLatLong.getAddress();
                String value3 = getAddFromLatLong.getCountry();
                String value4 = getAddFromLatLong.getLocality();
                String value5 = getAddFromLatLong.getPincode();
                String value6 = getAddFromLatLong.getState();

                //set current address
                select_tv.setText(value);
            }
        });

    }
```

```java
// we check location permition
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
    }
```

```java

//here we get location permition result(permition enable or disable)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CODE: {
                if ((grantResults[0] == 0)) {
                    checkPermition = 1;
                    try {
                        trackGPSLocation = new TrackGPSLocation(MainActivity.this);
                    } catch (Exception e) {
                        e.fillInStackTrace();
                    }
                } else {
                    checkPermition = 0;
                }
                return;
            }
        }
    }
```

<h2>Created and maintained by:</h2>
<p>Er.Prem singh daksha  premsingh8171@gmail.com</p>
<p><a href="https://www.linkedin.com/in/prem-singh-daksha-82az/"> <img src="https://github.com/anitaa1990/DeviceInfo-Sample/blob/master/media/linkedin-icon.png" alt="Linkedin" style="max-width:100%;"> </a></p>
