/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos.Factory;

/**
 *
 * @author Simón David Cruz S
 */
public class ProductoPerecederoFactory implements ProductoFactory{
    
    @Override
    public Bebidas crearBebidas() {
        return new BebidasPerecedero();
    }

    @Override
    public Congelados crearCongelados() {
        return new CongeladosPerecedero();
    }

    @Override
    public Farmaceuticos crearFarmaceuticos() {
        return new FarmaceuticosPerecedero();
    }

    @Override
    public Higiene_y_Limpieza crearHigiene_y_Limpieza() {
        return new Higiene_y_LimpiezaPerecedero();
    }

    @Override
    public Mascotas crearMascotas() {
        return new MascotasPerecedero();
    }

    @Override
    public Panaderia_y_Pasteleria crearPanaderia_y_Pasteleria() {
        return new Panaderia_y_PasteleriaPerecedero();
    }
}
