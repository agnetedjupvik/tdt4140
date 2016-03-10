package input;

public class Snapshot {
    public Datapoint accelerator_pedal_position;
    public Datapoint brake_pedal_status;
    public Datapoint button_state;
    public Datapoint door_status;
    public Datapoint engine_speed;
    public Datapoint fuel_consumed_since_restart;
    public Datapoint fuel_level;
    public Datapoint headlamp_status;
    public Datapoint ignition_status;
    public Datapoint latitude;
    public Datapoint longitude;
    public Datapoint odometer;
    public Datapoint steering_wheel_angle;
    public Datapoint torque_at_transmission;
    public Datapoint transmission_gear_position;
    public Datapoint vehicle_speed;
    public Datapoint speed_limit;
    public Datapoint windshield_wiper_status;
    public Datapoint turning_lights;

    public void addPoint(Datapoint datapoint) {
        switch (datapoint.getDatatype()) {
            case accelerator_pedal_position: accelerator_pedal_position = datapoint; break;
            case brake_pedal_status: brake_pedal_status = datapoint; break;
            case button_state: button_state = datapoint; break;
            case door_status: door_status = datapoint; break;
            case engine_speed: engine_speed = datapoint; break;
            case fuel_consumed_since_restart: fuel_consumed_since_restart = datapoint; break;
            case fuel_level: fuel_level = datapoint; break;
            case headlamp_status: headlamp_status = datapoint; break;
            case ignition_status: ignition_status = datapoint; break;
            case latitude: latitude = datapoint; break;
            case longitude: longitude = datapoint; break;
            case odometer: odometer = datapoint; break;
            case steering_wheel_angle: steering_wheel_angle = datapoint; break;
            case torque_at_transmission: torque_at_transmission = datapoint; break;
            case transmission_gear_position: transmission_gear_position = datapoint; break;
            case vehicle_speed: vehicle_speed = datapoint; break;
            case speed_limit: speed_limit = datapoint; break;
            case windshield_wiper_status:
                windshield_wiper_status = datapoint;
                break;
            case turning_lights:
                turning_lights = datapoint;
                break;
        }
    }

}
