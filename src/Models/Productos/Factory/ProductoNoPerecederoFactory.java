/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos.Factory;

/**
 *
 * @author Simón David Cruz S
 */
public class ProductoNoPerecederoFactory implements ProductoFactory{

    @Override
    public Bebidas crearBebidas() {
        return new BebidasNoPerecedero();
    }

    @Override
    public Congelados crearCongelados() {
        return new CongeladosNoPerecedero();
    }

    @Override
    public Farmaceuticos crearFarmaceuticos() {
        return new FarmaceuticosNoPerecedero();
    }

    @Override
    public Higiene_y_Limpieza crearHigiene_y_Limpieza() {
        return new Higiene_y_LimpiezaNoPerecedero();
    }

    @Override
    public Mascotas crearMascotas() {
        return new MascotasNoPerecedero();
    }

    @Override
    public Panaderia_y_Pasteleria crearPanaderia_y_Pasteleria() {
        return new Panaderia_y_PasteleriaNoPerecedero();
    }
    
}
