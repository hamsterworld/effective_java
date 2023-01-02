package effective.java.item34;

/**
 * 이렇게 열거타입에
 * 필드와 매서드또한 추가할수있다.
 *
 * enum 을 굳이 다른데 노출시킬필요가없다면
 * 선언한 클래스혹은 패키지에서만 사용가능한 private 나 package-private 로 구성하라. => WeightTable Class 로
 */
enum Planet {
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
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass()           { return mass; }
    public double radius()         { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;  // F = ma
    }

    public static void main(String[] args) {
        double v = Planet.MARS.surfaceGravity();
        System.out.println(v);
        double v1 = Planet.EARTH.surfaceWeight(10.34);
        System.out.println(v1);

        double earthWeight = 10.32;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        Planet[] values = Planet.values();
        for (Planet value : values) {
            System.out.println(" 행성 "+value.name()+"에서의 무게는 "+value.surfaceWeight(mass));
        }

        WeightTable.Planet1 jupiter = WeightTable.Planet1.JUPITER;
        // 다른 매서드 사용불가
    }
}
