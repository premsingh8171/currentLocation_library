# currentLocation_library
get current location 

## Installation

-  Add the following to your project level `build.gradle`:
 
```gradle
allprojects {
	repositories {
		maven { 
    url 'https://jitpack.io' }
	}
}
```
  -  Add this to your app `build.gradle`:
 
```gradle
dependencies {
      
}
```
## Using onClick

```java

  -  Define 
  
    private GetAddFromLatLong getAddFromLatLong;
    private TrackGPSLocation trackGPSLocation;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        select_tv = findViewById(R.id.select_tv);
        trackGPSLocation = new TrackGPSLocation(MainActivity.this);
        getAddFromLatLong = new GetAddFromLatLong(MainActivity.this);

        findViewById(R.id.selectadd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //here we passes the lat long by sing trackGPSAddress
                getAddFromLatLong.SaveLocationData(trackGPSLocation.getLatitude(), trackGPSLocation.getLongitude());
                String value = getAddFromLatLong.getCity();

                //set current address
                select_tv.setText(value);
            }
        });

    }
```

<h2>Created and maintained by:</h2>
<p>Er.Prem singh daksha  premsingh8171@gmail.com</p>
<p><a href="https://www.linkedin.com/in/prem-singh-daksha-82az/"> <img src="https://github.com/anitaa1990/DeviceInfo-Sample/blob/master/media/linkedin-icon.png" alt="Linkedin" style="max-width:100%;"> </a></p>
