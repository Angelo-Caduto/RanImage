package com.fallenangel.android.mobile.ranimage.di.module

import android.content.Context
import com.esafirm.rxdownloader.RxDownloader
import com.fallenangel.android.mobile.data.fileystem.DownloadFileManager
import com.fallenangel.android.mobile.data.network.ImageApi
import com.fallenangel.android.mobile.data.network.RetrofitClient
import com.fallenangel.android.mobile.data.repositories.DownloaderImpl
import com.fallenangel.android.mobile.data.repositories.ImageUrlRepositoryImpl
import com.fallenangel.android.mobile.domain.interactor.RandomImageInteractor
import com.fallenangel.android.mobile.domain.repository.Downloader
import com.fallenangel.android.mobile.domain.repository.ImageRepository
import com.fallenangel.android.mobile.domain.utils.DisposableManager
import com.fallenangel.android.mobile.domain.utils.SchedulersProvider
import com.fallenangel.android.mobile.ranimage.di.scope.ApplicationScope
import com.fallenangel.android.mobile.ranimage.utils.PermissionManager
import com.fallenangel.android.mobile.ranimage.utils.SchedulersProviderImpl
import dagger.Module
import dagger.Provides

/**
 * Created by NineB on 10/29/2018.
 */
@Module class UtilsModule {

    @Provides
    @ApplicationScope
    internal fun provideRxDownloader(context: Context) = RxDownloader(context)
    @Provides
    @ApplicationScope
    internal fun providepermissionsMAnager(context: Context) = PermissionManager(context)

    @Provides
    @ApplicationScope
    internal fun provideImgApi() : ImageApi = RetrofitClient().getImageApi()

    @Provides
    @ApplicationScope
    internal fun provideRandomImageRepository(imgApi: ImageApi) : ImageRepository  = ImageUrlRepositoryImpl(imgApi)

    @Provides
    @ApplicationScope
    internal fun provideDownloadFileManager(context: Context, rxDownloader: RxDownloader): DownloadFileManager = DownloadFileManager(context, rxDownloader)

    @Provides
    @ApplicationScope
    internal fun provideRandomDownloader(downloadFileManager: DownloadFileManager): Downloader = DownloaderImpl(downloadFileManager)

    @Provides
    @ApplicationScope
    internal fun provideschedulersProvider(): SchedulersProvider  = SchedulersProviderImpl()

    @Provides
    @ApplicationScope
    internal fun provideRandomImgInteractor(
            imageRepository: ImageRepository,
            downloader: Downloader,
            schedulersProvider: SchedulersProvider
    ) = RandomImageInteractor(imageRepository, downloader, schedulersProvider)

    @Provides
    @ApplicationScope
    internal fun provideDisposableManager() = DisposableManager()
}