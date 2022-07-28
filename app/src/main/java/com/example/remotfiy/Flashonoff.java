package com.example.remotfiy;


import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;

public class Flashonoff {
    Context context;
    //    Camera camera;
//    Camera.Parameters parameters;
    boolean isFlashOn = false;

    public Flashonoff(Context context) {
        this.context = context;
    }

    public void turnonFlash() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CameraManager cameraManager = (CameraManager) this.context.getSystemService(Context.CAMERA_SERVICE);

            try {
                String cameraId = cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(cameraId, true);
                isFlashOn = true;

            } catch (Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }


//        }else{
//            this.camera=Camera.open();
//            this.parameters=camera.getParameters();
//            this.parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//            this.camera.setParameters(parameters);
//            this.camera.startPreview();
//            this.isFlashOn=true;

        }

    }

    public boolean turnoffFlash() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CameraManager cameraManager = (CameraManager) this.context.getSystemService(Context.CAMERA_SERVICE);

            try {
                String cameraId = cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(cameraId, false);
                isFlashOn = false;
                return true;


            } catch (Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                return false;
            }

        }


//        else {
//            this.parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
//            this.camera.setParameters(parameters);
//            this.camera.stopPreview();
//            this.isFlashOn = false;}
        return false;
    }


}

