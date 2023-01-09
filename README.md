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
/framer/v1.0/calc?latitude1=51.9120268350476&longitude1=7.6338728239553495&latitude2=51.911510620555674&longitude2=7.632810650837488&focal_length=400&aperture=4.5&sensor_format="full_format"&orientation="landscape"

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
  "focal_length":400.0,
  "aperture":4.5,
  "orientation":"landscape",
  "distance_to_subject":92.95879480138197,
  "hyper_focal_distance":1226.4536398467437,
  "fov_width":8.355580723679628,
  "fov_height":5.570387763842713,
  "fov_width_angle":8.982433522447536,
  "fov_height_angle":5.9905271280243655,
  "dof_near_limit":86.43363715314476,
  "dof_far_limit":100.54961363096433,
  "dof_in_front":6.525157648237212,
  "dof_behind":7.590818829582361,
  "dof_total":14.115976477819572,
  "max_subject_height":4.3851938819213565,
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
              51.911843452074216,
              7.6351948851444105
            ],
            [
              51.911843452074216,
              7.632550762766364
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
              51.91280314884838,
              7.628274849095257
            ],
            [
              51.912929907913,
              7.627360593104878
            ],
            [
              51.912929907913,
              7.640385054805796
            ],
            [
              51.91280314884838,
              7.639470798815416
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