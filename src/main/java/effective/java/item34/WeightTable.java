package effective.java.item34;

/**
 * 행성 무게를 계산하는 매서드가 Client 에 노출될 이유가없다면
 * private, package-private 로 막아서 나의 class,package 에서만 사용할수있게 캡슐화해라.
 */
public class WeightTable {

    public void calculateAllPlanetWight(){
        double earthWeight = 10.32;
        double mass = earthWeight / Planet1.EARTH.surfaceGravity();
        Planet1[] values = Planet1.values();
        for (Planet1 value : values) {
            System.out.println(" 행성 "+value.name()+"에서의 무게는 "+value.surfaceWeight(mass));
        }
    }

    enum Planet1 {
        MERCURY(3.302e+23, 2.439e6),
        VENUS  (4.869e+24, 6.052e6),
        EARTH  (5.975e+24, 6.378e6),
        MARS   (6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN (5.685e+26, 6.027e7),
        URANUS (8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7);

        private final double mass;           // 질량(단위: 킬로그램)
        private final double radius;         // 반지름(단위: 미터)
        private final double surfaceGravity; // 표면중력(단위: m / s^2)

        // 중력상수(단위: m^3 / kg s^2)
        private static final double G = 6.67300E-11;

        // 생성자
        Planet1(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        private double mass()           { return mass; }
        private double radius()         { return radius; }
        private double surfaceGravity() { return surfaceGravity; }

        private double surfaceWeight(double mass) {
            return mass * surfaceGravity;  // F = ma
        }

    }
}