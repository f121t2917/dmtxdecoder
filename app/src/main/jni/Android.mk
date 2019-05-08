MY_LOCAL_PATH := $(call my-dir)

#-----libdmtx & dmtx-wrappers-----
include $(CLEAR_VARS)

OpenCV_INSTALL_MODULES := on
OpenCV_CAMERA_MODULES := on

OPENCV_LIB_TYPE := SHARED

LOCAL_PATH := $(MY_LOCAL_PATH)/../libdmtx

LOCAL_MODULE := libdmtx
    
LOCAL_SRC_FILES := ./dmtx.c \
	../dmtx-wrappers/java/native/org_libdmtx_DMTXImage.c

LOCAL_C_INCLUDES := \
	$(LOCAL_PATH) \
	$(MY_LOCAL_PATH)/../dmtx-wrappers/java/native

include $(BUILD_SHARED_LIBRARY)

ifeq ("$(wildcard $(OPENCV_MK_PATH))","")
include ../../../../native/jni/OpenCV.mk
else include $(OPENCV_MK_PATH)
endif

include $(BUILD_SHARED_LIBRARY)


