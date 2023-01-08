## Framer

A little service to calculate data related to field of view and depth of field for photography things.

Returns a json format that contains data related to field of view and depth of field.
All distances are either in millimeter (sensor_width, sensor_height, focal_length) or in meter (distance_to_subject, hyper_focal_distance, fov_width, fov_height, dof_near_limit, dof_far_limit, dof_total)
All angles are given in degrees (fov_width_angle, fov_height_angle)

The focal length must be in the range from 8 - 2400 mm

The aperture must be in the range of 0.7 - 99

The distance between the camera and the subject must be in the range of 0.01 - 9999 m

In case of an error you will get the same response as with valid data but all values are 0 and the msg at the end will contain some info.

[Swagger documentation](http://hansolo.eu:8081/swagger-ui)

If you call the endpoint with:
/framer/calc?latitude1=51.9120268350476&longitude1=7.6338728239553495&latitude2=51.911510620555674&longitude2=7.632810650837488&focal_length=400&aperture=4.5&sensor_format="full_format"&orientation="landscape"

You will get this response:
````json
{
  "camera_latitude":51.9120268350476,
  "camera_longitude":7.6338728239553495,
  "subject_latitude":51.911510620555674,
  "subject_longitude":7.632810650837488,
  "sensor_format":"full_format",
  "sensor_width":36.0,
  "sensor_height":23.9,
  "focal_length":400,
  "aperture":4.5,
  "orientation":"landscape",
  "distance_to_subject":92.96,
  "hyper_focal_distance":1226.45,
  "fov_width":8.36,
  "fov_height":5.57,
  "fov_width_angle":0.09,
  "fov_height_angle":0.06,
  "dof_near_limit":86.43,
  "dof_far_limit":100.55,
  "dof_total":14.12,
  "features":[
    {
      "type":"Feature",
      "geometry":{
        "type":"Polygon",
        "coordinates":[
          [
            [
              51.9120268350476,
              7.6338728239553495
            ],
            [
              51.91286189809355,
              7.63381198393061
            ],
            [
              51.91286189809355,
              7.633933663980064
            ]
          ]
        ]
      },
      "properties":{
        "name":"fovTriangle"
      }
    },
    {
      "type":"Feature",
      "geometry":{
        "type":"Polygon",
        "coordinates":[
          [
            [
              51.912803281607204,
              7.633816254614454
            ],
            [
              51.91293008757662,
              7.6338070157628275
            ],
            [
              51.91293008757662,
              7.633938632147846
            ],
            [
              51.912803281607204,
              7.633929393296321
            ]
          ]
        ]
      },
      "properties":{
        "name":"dofTrapezoid"
      }
    }
  ],
  "msg":""
}
```` 
Explanation:
![Image](https://i.ibb.co/9hdxbSQ/image1.png)