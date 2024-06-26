package io.shortway.kobankat

import cocoapods.RevenueCat.RCPackage
import cocoapods.RevenueCat.RCPackageType
import cocoapods.RevenueCat.RCPackageTypeAnnual
import cocoapods.RevenueCat.RCPackageTypeCustom
import cocoapods.RevenueCat.RCPackageTypeLifetime
import cocoapods.RevenueCat.RCPackageTypeMonthly
import cocoapods.RevenueCat.RCPackageTypeSixMonth
import cocoapods.RevenueCat.RCPackageTypeThreeMonth
import cocoapods.RevenueCat.RCPackageTypeTwoMonth
import cocoapods.RevenueCat.RCPackageTypeUnknown
import cocoapods.RevenueCat.RCPackageTypeWeekly
import cocoapods.RevenueCat.offeringIdentifier
import io.shortway.kobankat.models.StoreProduct

public actual typealias Package = RCPackage

public actual val Package.identifier: String
    get() = identifier()
public actual val Package.packageType: PackageType
    get() = packageType().toPackageType()
public actual val Package.storeProduct: StoreProduct
    get() = storeProduct()
public actual val Package.presentedOfferingContext: PresentedOfferingContext
    get() = presentedOfferingContext()
public actual val Package.offeringIdentifier: String
    get() = offeringIdentifier()

internal fun RCPackageType.toPackageType(): PackageType =
    when (this) {
        RCPackageTypeUnknown -> PackageType.UNKNOWN
        RCPackageTypeCustom -> PackageType.CUSTOM
        RCPackageTypeLifetime -> PackageType.LIFETIME
        RCPackageTypeAnnual -> PackageType.ANNUAL
        RCPackageTypeSixMonth -> PackageType.SIX_MONTH
        RCPackageTypeThreeMonth -> PackageType.THREE_MONTH
        RCPackageTypeTwoMonth -> PackageType.TWO_MONTH
        RCPackageTypeMonthly -> PackageType.MONTHLY
        RCPackageTypeWeekly -> PackageType.WEEKLY
        else -> error("Unexpected RCPackageType: $this")
    }

public actual enum class PackageType {
    /**
     * A package that was defined with a custom identifier.
     */
    UNKNOWN,

    /**
     * A package that was defined with a custom identifier.
     */
    CUSTOM,

    /**
     * A package configured with the predefined lifetime identifier.
     */
    LIFETIME,

    /**
     * A package configured with the predefined annual identifier.
     */
    ANNUAL,

    /**
     * A package configured with the predefined six month identifier.
     */
    SIX_MONTH,

    /**
     * A package configured with the predefined three month identifier.
     */
    THREE_MONTH,

    /**
     * A package configured with the predefined two month identifier.
     */
    TWO_MONTH,

    /**
     * A package configured with the predefined monthly identifier.
     */
    MONTHLY,

    /**
     * A package configured with the predefined weekly identifier.
     */
    WEEKLY,
}
